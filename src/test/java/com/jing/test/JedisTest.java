package com.jing.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setJedis() {
        jedis = new Jedis("192.168.159.129", 6379);
        jedis.auth("123321");
        jedis.select(0);
    }

    @Test
    void testString(){
        String result = jedis.set("name","jack");
        System.out.println("result = " + result);
        String name = jedis.get("name");
        System.out.println("name = "+ name);
    }

    @Test
    void testHash(){
        jedis.hset("user:1","name","jack");
        jedis.hset("user:1","age","21");

        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown(){
        if (jedis!=null) {
            jedis.close();
        }
    }
}
