package com.qf.controller;

import com.qf.entity.DevUser;
import com.qf.enums.AppEnum;
import com.qf.service.DevUserService;
import com.qf.util.R;
import com.qf.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dev/user")
@Slf4j
public class DevUserController {

    @Autowired
    private DevUserService devUserService;

    //1. 转发到注册页面.
    @GetMapping("/register-ui")
    public String registerUI(){
        return "dev/user/register";
    }

    //异步校验用户名接口
    @PostMapping("/check-devUsername")
    @ResponseBody
    public ResultVO checkDevUsername(String devUsername){
        //参数校验
        if (devUsername == null || devUsername.length()<5){
            log.info("【校验用户名】 用户名不能为空且长度不能小于5！！！devUsername={}",devUsername);
            return R.error(AppEnum.PARAM_ERROR.getCode(),"用户名不能为空且长度不能小于5！！！");
        }
        //调用service查询用户信息
        DevUser devUser = devUserService.findByDevUsername(devUsername);
        //判断查询结果
        if (devUser !=null){
            log.info("【校验用户名】用户名已存在，请重新输入！！！devUsername={}",devUsername);
            return R.error(AppEnum.PARAM_ERROR.getCode(),"用户名已存在，请重新输入！！！");
        }
        return R.ok();
    }

    //2. 转发到登录页面.
    @GetMapping("/login-ui")
    public String loginUI(){
        return "dev/user/login";
    }

}
