package com.qf.controller;

import com.qf.entity.AppCategory;
import com.qf.entity.AppInfo;
import com.qf.entity.DataDictionary;
import com.qf.enums.AppEnum;
import com.qf.enums.AppTypeCodeEnum;
import com.qf.form.AppMaintainForm;
import com.qf.service.AppCategoryService;
import com.qf.service.AppInfoService;
import com.qf.service.DataDictionaryService;
import com.qf.util.R;
import com.qf.vo.DownloadsVO;
import com.qf.vo.LayUiTableVO;
import com.qf.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangpeng
 */
@Controller
@RequestMapping("/dev/app")
@Slf4j
public class DevAppController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private AppCategoryService appCategoryService;


    // 一级分类父id
    private final int LEVEL_ONE_PARENT_ID = 0;

    //1.跳转到后台首页
    @GetMapping("/index")
    public String index(){
        return "/dev/app/index";
    }


    //2. 查询APP下载量TOP FIVE
    @GetMapping("/downloads-top-five")
    @ResponseBody
    public ResultVO downloadsTopFive(){
        //1. 调用service查询.
        List<DownloadsVO> data = appInfoService.findDownloadsTopFive();

        //2. 响应信息
        return R.ok(data);
    }


    //3. 跳转到app维护页面.
    @GetMapping("/app-maintain")
    public String appMaintain(Model model){
        //1. 所属平台.
        List<DataDictionary> flatFormList = dataDictionaryService.findByTypeCode(AppTypeCodeEnum.APP_FLATFORM.getTypeCode());
        model.addAttribute("flatFormList",flatFormList);
        //2. app状态.
        List<DataDictionary> appStatusList = dataDictionaryService.findByTypeCode(AppTypeCodeEnum.APP_STATUS.getTypeCode());
        model.addAttribute("appStatusList",appStatusList);
        //3. 一级分类.
        List<AppCategory> LevelOneList = appCategoryService.findByParentId(LEVEL_ONE_PARENT_ID);
        model.addAttribute("levelOneList",LevelOneList);

        return "dev/app/app-maintain";
    }

    //4. 根据parentId查询分类信息.
    @GetMapping("/category-by-parent-id")
    @ResponseBody
    public ResultVO categoryByParentId(Integer parentId){
        //1. 校验参数.
        if(parentId == null || parentId <= 0){
            log.info("【分类三级联动】 参数不合法!!");
            return R.error(AppEnum.PARAM_ERROR);
        }
        //2. 调用service查询分类信息.
        List<AppCategory> data = appCategoryService.findByParentId(parentId);

        //3. 响应信息.
        return R.ok(data);
    }

    //app维护页面table信息展示

//    表格信息展示
    @GetMapping("/table-list")
    @ResponseBody
    public LayUiTableVO tableList(@RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "5")Integer limit,
                                  AppMaintainForm form){
        //将参数封装到一个map中
        Map<String,Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        param.put("form",form);
        LayUiTableVO vo = appInfoService.findAllAppInfo(param);
        return vo;
    }

    //跳转到添加页面弹出层
    @GetMapping("/base-add-ui")
    public String BaseAddUI(Model model){
        //1. 所属平台.
        List<DataDictionary> flatFormList = dataDictionaryService.findByTypeCode(AppTypeCodeEnum.APP_FLATFORM.getTypeCode());
        model.addAttribute("flatFormList",flatFormList);
        //2. 一级分类.
        List<AppCategory> LevelOneList = appCategoryService.findByParentId(LEVEL_ONE_PARENT_ID);
        model.addAttribute("levelOneList",LevelOneList);
        return "dev/app/base-add";
    }

    //执行添加
    @PostMapping("/base-add")
    @ResponseBody
    public ResultVO baseAdd(@Valid AppInfo appInfo, BindingResult bindingResult){
        //校验参数
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.info("【添加app基础信息】 参数错误！msg={}",msg);
            return R.error(AppEnum.PARAM_ERROR.getCode(),msg);
        }
        //调用service保存
        appInfoService.add(appInfo);
        //响应数据
        return R.ok();
    }

    //上架
    @PostMapping("/up")
    @ResponseBody
    public ResultVO upSale(@RequestParam(value = "ids[]")Integer[] ids){
        //校验参数
        if (ids == null || ids.length == 0){
            log.info("【上架功能】 参数错误，上架失败！ids={}",ids);
            return R.error(AppEnum.PARAM_ERROR.getCode(),"参数错误，上架失败！");
        }
        //调用service修改
        appInfoService.up(ids);
        //响应数据
        return R.ok();
    }
}
