package com.qf.service.impl;

import com.qf.constant.AppConstant;
import com.qf.entity.DevUser;
import com.qf.enums.AppEnum;
import com.qf.enums.DevUserStateEnum;
import com.qf.exception.AppException;
import com.qf.mapper.DevUserMapper;
import com.qf.service.DevUserService;
import com.qf.service.SendEmailService;
import com.qf.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Autowired
    private SendEmailService sendEmailService;

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

    @Override
    @Transactional
    public void addDevUser(DevUser devUser) {
        //封装数据
        //生成盐
        devUser.setDevSalt(RandomUtil.random());
        //密码加密
        String pwd = new Md5Hash(devUser.getDevPassword(),devUser.getDevSalt(), AppConstant.HASH_ITERATIONS).toString();
        //生成code
        devUser.setDevCode(RandomUtil.random());
        //
        devUser.setDevState(DevUserStateEnum.NOT_ACTIVE.getState());
        //执行注册功能
        int count = devUserMapper.insertSelective(devUser);
        //健壮性判断
        if (count!=1){
            log.error("【注册功能】 注册失败！！！devUser={}",devUser);
            throw new AppException(AppEnum.DEV_USER_REGISTER_ERROR);
        }
        //发送验证邮件
        sendEmailService.sendEmail(devUser);
    }
}
