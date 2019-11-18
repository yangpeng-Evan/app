package com.qf.service;

import com.qf.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void set() {
        //Set<String> keys = redisTemplate.keys("*");
        Set<String> keys = redisTemplate.keys("*");
        System.out.println(keys);
        /*HostAndPort h1 = new HostAndPort("118.190.134.68",7001);
        HostAndPort h2 = new HostAndPort("118.190.134.68",7002);
        HostAndPort h3 = new HostAndPort("118.190.134.68",7003);
        HostAndPort h4 = new HostAndPort("118.190.134.68",7004);
        HostAndPort h5 = new HostAndPort("118.190.134.68",7005);
        HostAndPort h6 = new HostAndPort("118.190.134.68",7006);
        Set<HostAndPort> set = new HashSet<>();
        set.add(h1);
        set.add(h2);
        set.add(h3);
        set.add(h4);
        set.add(h5);
        set.add(h6);

        JedisCluster jedisCluster = new JedisCluster(set);

        jedisCluster.set("name","123456");

        jedisCluster.close();
*/

    }
}
