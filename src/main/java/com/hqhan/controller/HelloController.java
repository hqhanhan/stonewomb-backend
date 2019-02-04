package com.hqhan.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title: HelloController
 * @description:
 * @email: hqhan8080@Gmail.com
 * @auther: hanhouqi
 * @date: 2018/9/8 02:06
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}