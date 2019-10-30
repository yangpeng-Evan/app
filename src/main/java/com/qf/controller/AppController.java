package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangpeng
 */
@Controller
@RequestMapping("/dev/app")
public class AppController {

    //转发到index页面
    @GetMapping("/index-ui")
    public String indexUI(){
        return "/dev/app/index";
    }

}
