package com.qf.service;

import com.qf.entity.DevUser;

/**
 *  开发者模块的用户service.
 */
public interface DevUserService {


    /**
     * 1. 根据用户名查询用户信息..
     * @param username
     * @return
     */
    DevUser findByDevUsername(String username);

    void addDevUser(DevUser devUser);
}
