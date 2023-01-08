package com.jing.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static{
        //配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxWaitMillis(1000);

        jedisPool = new JedisPool(jedisPoolConfig,
                "192.168.159.129",6379,1000,"123321");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
