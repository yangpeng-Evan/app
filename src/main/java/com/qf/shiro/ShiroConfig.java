package com.qf.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qf.service.FilterChainService;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {



    //0. Realm
    @Bean
    public Realm realm(){
        return new DevRealm();
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
    //1. SecurityManager
    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm){
        //1. 创建安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //2. 注入realm
        securityManager.setRealm(realm);
        //3. 返回安全管理器对象
        return securityManager;
    }


    //2. ShiroFilterChainDefinition
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(FilterChainService filterChainService){
        //1. 创建过滤器链对象.
        DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        //2. 调用userService查询全部过滤器链的信息.
        LinkedHashMap<String,String> filterChainDefinition = filterChainService.findFilterChainDefinition();
        //3. 设置过滤器链
        shiroFilterChainDefinition.addPathDefinitions(filterChainDefinition);
        //4. 返回过滤器链对象.
        return shiroFilterChainDefinition;
    }


}
