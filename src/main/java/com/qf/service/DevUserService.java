package com.qf.service;

import com.qf.entity.DevUser;

import java.util.List;

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

    /**
     * 根据邮箱名和code查询并修改用户状态
     * @param email
     * @param code
     */
    void activeDevUser(String email, String code);

    /**
     * 重新发送激活邮件接口
     * @param devUsername
     * @param devEmail
     */
    void resendEmail(String devUsername, String devEmail);

    /**
     * 查询查过三天未激活的用户信息
     * @return
     */
    List<Integer> findAllInactiveDevUser();

    /**
     * 删除对应的用户信息
     * @param ids
     */
    void deleteByIds(List<Integer> ids);
}
