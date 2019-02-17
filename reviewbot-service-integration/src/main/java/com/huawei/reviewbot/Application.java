package com.huawei.reviewbot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * project main start
 *
 * @author hqhan8080@Gmail.com
 * @date 2018/9/8 02:03
 * @version v1.0
 */

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}