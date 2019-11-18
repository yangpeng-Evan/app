package com.qf.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author yangpeng
 */
@Component
public class RedisUtil {

    @Resource
    private JedisPool jedisPool;

    //设置值
    public void set(byte[] key,byte[] value){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
        } finally {
            jedis.close();
        }
    }

    //取值
    public byte[] get(byte[] key){
        Jedis jedis = jedisPool.getResource();
        try {
            byte[] value = jedis.get(key);
            return value;
        } finally {
            jedis.close();
        }
    }

    //设置生存时间
    public void expire(byte[] key,Integer seconds){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.expire(key, seconds);
        } finally {
            jedis.close();
        }
    }

    //根据key删除
    public void del(byte[] key){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    //查询所有的存活的key
    public Set<byte[]> keys(byte[] pattern){
        Jedis jedis = jedisPool.getResource();
        try {
            Set<byte[]> keys = jedis.keys(pattern);
            return keys;
        } finally {
            jedis.close();
        }
    }

    //设置值并设置生存时间
    public void setAndExpire(byte[] key,byte[] value,Integer seconds){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            jedis.expire(key,seconds);
        } finally {
            jedis.close();
        }
    }

    //获取值并设置生存时间
    public byte[] getAndExpire(byte[] key,Integer seconds){
        Jedis jedis = jedisPool.getResource();
        try {
            byte[] value = jedis.get(key);
            jedis.expire(key,seconds);
            return value;
        } finally {
            jedis.close();
        }
    }
}
