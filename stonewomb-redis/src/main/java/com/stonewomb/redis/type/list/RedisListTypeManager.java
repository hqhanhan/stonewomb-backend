package com.stonewomb.redis.type.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 〈description〉<br>
 * 〈list manager〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-03-02 12:45
 */

@Component
public class RedisListTypeManager {


    @Autowired
    private StringRedisTemplate redisTemplate;


    public void put(){

    }

}
