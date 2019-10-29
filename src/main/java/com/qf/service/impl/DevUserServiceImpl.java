package com.qf.service.impl;

import com.qf.entity.DevUser;
import com.qf.mapper.DevUserMapper;
import com.qf.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser findByDevUsername(String username) {
        //1. 封装数据.
        DevUser param = new DevUser();
        param.setDevUsername(username);
        //2. 执行查询.
        DevUser devUser = devUserMapper.selectOne(param);
        //3. 返回结果.
        return devUser;
    }
}
