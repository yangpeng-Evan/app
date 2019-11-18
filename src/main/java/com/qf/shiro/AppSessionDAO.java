package com.qf.shiro;

import com.qf.enums.AppEnum;
import com.qf.exception.AppException;
import com.qf.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangpeng
 */

@Slf4j
@Component
public class AppSessionDAO extends AbstractSessionDAO {

    @Autowired
    private RedisUtil redisUtil;
    private final String SESSION_PREFIX="shiro-session:";
    private final Integer SESSION_TIMEOUT = 600;
    //添加
    @Override
    protected Serializable doCreate(Session session) {
        //判空
        if (session == null){
            log.error("【添加session】session不能为空！！");
            throw new AppException(AppEnum.SESSION_ISEMPTY);
        }
        //1、生成sessionId
        Serializable sessionId = super.generateSessionId(session);
        //2、将生成的sessionId和session绑定到一起
        super.assignSessionId(session,sessionId);
        //3、设置一个key
        byte[] key = SerializationUtils.serialize(SESSION_PREFIX + sessionId);
        //4、准备一个value
         byte[] value = SerializationUtils.serialize(session);
        //5、保存到Redis并设置生存时间
        redisUtil.setAndExpire(key,value,SESSION_TIMEOUT);
        //7、返回sessionId
        return sessionId;
    }

    //读取
    @Override
    protected Session doReadSession(Serializable sessionId) {
        //判空
        if (sessionId == null){
            log.error("【获取session】sessionId不能为空！！");
            throw new AppException(AppEnum.SESSIONID_ISEMPTY);
        }
        System.out.println("去redis查询session信息! ");
         //封装key
        byte[] key = SerializationUtils.serialize(SESSION_PREFIX + sessionId);
        //通过key获取value并重新设置生存时间
        byte[] value = redisUtil.getAndExpire(key, SESSION_TIMEOUT);
        //反序列化
        Session session  = (Session) SerializationUtils.deserialize(value);
        //返回
        return session;
    }

    //修改
    @Override
    public void update(Session session) throws UnknownSessionException {
        //判空
        if (session == null){
            log.error("【修改 session】session不能为空！！");
            throw new AppException(AppEnum.SESSION_ISEMPTY);
        }
        //1、生成sessionId

        Serializable sessionId = super.generateSessionId(session);
        //2、将生成的sessionId和session绑定到一起
        super.assignSessionId(session,sessionId);
        //3、设置一个key
        byte[] key = SerializationUtils.serialize(SESSION_PREFIX + sessionId);
        //4、准备一个value
        byte[] value = SerializationUtils.serialize(session);
        //5、保存到Redis并设置生存时间
        redisUtil.setAndExpire(key,value,SESSION_TIMEOUT);
    }

    //删除
    @Override
    public void delete(Session session) {
        //判空
        if (session == null){
            log.error("【删除session】session不能为空！！");
            throw new AppException(AppEnum.SESSION_ISEMPTY);
        }
        //1、生成sessionId
        Serializable sessionId = super.generateSessionId(session);
        //封装key
        byte[] key = SerializationUtils.serialize(SESSION_PREFIX + sessionId);
        //执行删除
        redisUtil.del(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        //生成key
        byte[] pattern = SerializationUtils.serialize(SESSION_PREFIX + "*");
        //通过keys'获取全部的set集合，
        Set<byte[]> keys = redisUtil.keys(pattern);
        //并且遍历，将数组反序列化为session并封装Set
        Set<Session> sessionSet = new HashSet<>();
        for (byte[] key : keys) {
            byte[] value = redisUtil.get(key);
            Session session = (Session) SerializationUtils.deserialize(value);
            sessionSet.add(session);
        }
        //        返回
        return sessionSet ;
    }
}
