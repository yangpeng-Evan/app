package com.qf.controller;

import com.qf.constant.AppConstant;
import com.qf.enums.AppEnum;
import com.qf.util.R;
import com.qf.util.RandomUtil;
import com.qf.util.UploadUtil;
import com.qf.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangpeng
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    private final String PIC_DIR = "images";
    private final String APK_DIR = "apks";

    @Resource
    private UploadUtil uploadUtil;

    @Value("${upload.pic.types}")
    private String types;

    @PostMapping("/pic")
    @ResponseBody
    public ResultVO uploadPic(MultipartFile file) throws IOException {
        //校验是否为null
        if (file == null){
            log.info("【文件上传】 图片不能为空！");
            return R.error(AppEnum.PARAM_ERROR.getCode(),"图片不能为空！");
        }
        //校验大小
        if (file.getSize()> AppConstant.MAX_UPLOAD_SIZE){
            log.info("【文件上传】 图片大小不能超过5M file.getSize={}",file.getSize());
            return R.error(AppEnum.PARAM_ERROR.getCode(),"图片大小不能查过5M");
        }
        //校验类型
        boolean flag = false;
        String[] typesArray = types.split(",");
        for (String type : typesArray) {
            if(StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),type)){
                //类型匹配
                flag = true;
                break;
            }
        }
        if (!flag){
            log.info("【文件上传】 文件类型不正确，请重新上传！file ={}",file);
            return R.error(AppEnum.PARAM_ERROR.getCode(),"文件类型不正确，请重新上传！");
        }
        //校验是否损坏
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null){
            log.info("【文件上传】 图片损坏，请重新上传！");
            return R.error(AppEnum.PARAM_ERROR.getCode(),"图片损坏，请重新上传！");
        }
        //设置图片新名称
        String prefixName = RandomUtil.random();
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newName = prefixName+suffixName;

        //调用阿里云的oss存储API存储
        String url = uploadUtil.uploadPic(PIC_DIR + "/" + newName, file.getInputStream());
        //响应数据
        Map<String,String> data = new HashMap<>();
        data.put("src",url);
        return R.ok(data);
    }
}
