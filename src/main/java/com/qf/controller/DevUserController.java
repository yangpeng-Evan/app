package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev/user")
public class DevUserController {


    //1. 转发到注册页面.
    @GetMapping("/register-ui")
    public String registerUI(){
        return "dev/user/register";
    }

    //2. 转发到登录页面.
    @GetMapping("/login-ui")
    public String loginUI(){
        return "dev/user/login";
    }

}
