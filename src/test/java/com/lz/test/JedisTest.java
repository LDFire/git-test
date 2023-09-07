package com.lz.test;

import com.lz.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;


import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        jedis = JedisConnectionFactory.getJedis();

        jedis.select(0);
    }

    @Test
    void testString(){
        String s = jedis.set("name", "张三");
        System.out.println(s);
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash(){
        jedis.hset("people:1","name","李四");
        Map<String, String> map = jedis.hgetAll("lz:product:2");
        System.out.println("map = " + map);
    }

    @AfterEach
    void tearDown(){
        if(jedis != null){
            jedis.close();
        }
    }

}
