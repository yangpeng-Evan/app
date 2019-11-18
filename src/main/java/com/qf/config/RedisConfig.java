package com.qf.config;

import com.qf.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @author yangpeng
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPool pool(){
        JedisPool jedisPool = new JedisPool(redisProperties.getHost(),redisProperties.getPort());
        return jedisPool;
    }
}
