package com.stonewomb.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈description〉<br>
 * 〈tst〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-03-02 12:51
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisListTest {

    @Autowired
    private StringRedisTemplate  redisTemplate;


    @Test
    public void put(){


        redisTemplate.opsForValue().set("key","value");

    }



}
