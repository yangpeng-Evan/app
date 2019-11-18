package com.qf.controller;

import com.qf.entity.*;
import com.qf.enums.AppEnum;
import com.qf.enums.AppTypeCodeEnum;
import com.qf.form.AppMaintainForm;
import com.qf.service.AppCategoryService;
import com.qf.service.AppInfoService;
import com.qf.service.AppVersionService;
import com.qf.service.DataDictionaryService;
import com.qf.util.R;
import com.qf.vo.DownloadsVO;
import com.qf.vo.LayUiTableVO;
import com.qf.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    @Autowired
    private AppVersionService appVersionService;


    // 一级分类父id
    private final int LEVEL_ONE_PARENT_ID = 0;

    //1.跳转到后台首页
    @GetMapping("/index")
    public String index(){
        return "dev/app/index";
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
    //下架
    @PostMapping("/down")
    @ResponseBody
    public ResultVO downSale(@RequestParam(value = "ids[]")Integer[] ids){
        //校验参数
        if (ids == null || ids.length == 0){
            log.info("【下架功能】 参数错误，下架失败！ids={}",ids);
            return R.error(AppEnum.PARAM_ERROR.getCode(),"参数错误，下架失败！");
        }
        //调用service修改
        appInfoService.down(ids);
        //响应数据
        return R.ok();
    }

    @PostMapping("/del")
    @ResponseBody
    public ResultVO delAppInfo(@RequestParam(value = "ids[]")Integer[] ids){
        //校验参数
        if (ids == null || ids.length == 0){
            log.info("【删除功能】 参数错误，删除失败！ids={}",ids);
            return R.error(AppEnum.PARAM_ERROR.getCode(),"参数错误，删除失败！");
        }
        //调用service删除appinfo
        appInfoService.del(ids);
        return R.ok();
    }

    @GetMapping("/version-add-ui/{id}")
    public String VersionAddUi(@PathVariable Integer id,Model model){
//        接收参数,调用service查询数据,三个最新的历史版本和appId放到req域中,转发页面
        List<AppVersion> list = appVersionService.findNewThreeVersions(id);
        model.addAttribute("versionList",list);
        model.addAttribute("appId",id);
        return "dev/app/version-add";
    }

    @PostMapping("/version-add")
    @ResponseBody
    public ResultVO versionAdd(@Valid AppVersion appVersion,BindingResult bindingResult){
//        2. controller接收参数并校验.
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.info("【新增版本号】 参数错误！appVersion={}",appVersion);
            return R.error(AppEnum.PARAM_ERROR.getCode(),msg);
        }
//        3. controller调用service保存.
        appVersionService.add(appVersion);
//        4.响应数据
        return R.ok(appVersion.getVersionNo());
    }

    @GetMapping("/version-edit-ui/{id}")
    public String versionEditUi(@PathVariable Integer id,Model model){
        //校验参数
        if (id == null){
            log.info("【编辑app版本】 参数错误！");
            return null;
        }
        //调用service查询app最新版本信息
        List<AppVersion> list = appVersionService.findNewThreeVersions(id);
        if (list.size()<1){
            log.info("【编辑app版本】 参数错误！查询不到版本信息！");
            return null;
        }
        //获取app最新的版本信息
        AppVersion appVersion = list.get(0);
        System.out.println(appVersion);
        //将查询到的最新的app版本信息设置到域中
        model.addAttribute("appVersion",appVersion);
        return "dev/app/version-edit";
    }

    @PostMapping("/version-edit")
    @ResponseBody
    public ResultVO versionEdit(@Valid AppVersion appVersion,BindingResult bindingResult,Integer appVersionId){
        //校验参数
        if (bindingResult.hasErrors()){
            log.info("【编辑app版本】 参数错误！ appversion={}",appVersion);
            return R.error(AppEnum.PARAM_ERROR);
        }
        appVersion.setId(appVersionId);
//        3. controller调用service更新.
        appVersionService.updateAppVersion(appVersion);
//        4.响应数据
        return R.ok(appVersion.getVersionNo());
    }
}
