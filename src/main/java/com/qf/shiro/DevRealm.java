package com.qf.shiro;

import com.qf.entity.DevUser;
import com.qf.service.DevUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class DevRealm extends AuthorizingRealm {


    @Autowired
    private DevUserService devUserService;

    // 设置MD5加密1024次.
    {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        this.setCredentialsMatcher(matcher);
    }



    @Override
    // 认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1. 获取用户输入的用户名.
        String username = (String) token.getPrincipal();
        //2. 根据用户名查询用户信息. (userService) (模拟数据库操作)
        DevUser devUser = devUserService.findByDevUsername(username);
        //3. 判断用户信息是否为null -> 直接返回true
        if(devUser == null){
            return null;
        }
        //4. 将正确的user对象和密码封装到AuthenticationInfo对象中.
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(devUser,devUser.getDevPassword(),"DevRealm");
        //5. 将盐设置到info对象中
        info.setCredentialsSalt(ByteSource.Util.bytes(devUser.getDevSalt()));
        //6. 返回AuthenticationInfo对象.
        return info;
    }




    @Override
    // 授权.
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }





}
