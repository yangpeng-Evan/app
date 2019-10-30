package com.qf.service.impl;

import com.qf.constant.AppConstant;
import com.qf.entity.DevUser;
import com.qf.enums.AppEnum;
import com.qf.enums.DevUserStateEnum;
import com.qf.exception.AppException;
import com.qf.mapper.DevUserMapper;
import com.qf.service.DevUserService;
import com.qf.service.SendEmailService;
import com.qf.util.Base64Utils;
import com.qf.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class DevUserServiceImpl implements DevUserService {

    @Resource
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
        //设置密码
        devUser.setDevPassword(pwd);
        // 设置用户状态
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

    @Override
    @Transactional
    public void activeDevUser(String email, String code) {
        //解码
        String deemail = Base64Utils.decode(email);
        String decode = Base64Utils.decode(code);
        //封装查询条件
        DevUser param = new DevUser();
        param.setDevEmail(deemail);
        param.setDevCode(decode);
        //查询用户信息
        DevUser devUser = devUserMapper.selectOne(param);
        //判断是否查询到用户信息
        if (devUser==null){
            log.error("【用户激活】 用户不存在，请先注册！！！");
            throw new AppException(AppEnum.DEV_USER_NOT_EXISTS);
        }else if (devUser.getDevState() == 1){
            log.error("【用户激活】 用户已激活，请直接登录！！！");
            throw new AppException(AppEnum.DEV_USER_ACTIVE_ERROR);
        }
        //封装修改的条件
        devUser.setDevState(DevUserStateEnum.ACTIVE.getState());
        //执行修改状态的操作
        int count = devUserMapper.updateByPrimaryKeySelective(devUser);
        if (count!=1){
            log.error("【用户激活】 修改用户状态失败！！！");
            throw new AppException(AppEnum.UPDATE_DEVUSER_STATE_ERROR);
        }

    }

    @Override
    public void resendEmail(String devUsername, String devEmail) {
        //封装查询参数
        DevUser param = new DevUser();
        param.setDevUsername(devUsername);
        param.setDevEmail(devEmail);
        //根据用户名和邮箱查询用户信息
        DevUser devUser = devUserMapper.selectOne(param);
        if (devUser==null){
            log.error("【用户激活】 用户不存在，请先注册！！！");
            throw new AppException(AppEnum.DEV_USER_NOT_EXISTS);
        }else if (devUser.getDevState() == 1){
            log.error("【用户激活】 用户已激活，请直接登录！！！");
            throw new AppException(AppEnum.DEV_USER_ACTIVE_ERROR);
        }
        //发送激活邮件
        sendEmailService.sendEmail(devUser);
    }

    @Override
    public List<Integer> findAllInactiveDevUser() {
        List<Integer> ids = devUserMapper.findAllInactiveDevUser();
        return ids;
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        //封装查询条件
        Example example = new Example(DevUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        //执行删除开发用户的操作
        devUserMapper.deleteByExample(example);
    }
}
