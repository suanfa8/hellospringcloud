package com.suanfa8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class UserController {

    // http://localhost:9999/user/showMsg
    @GetMapping("/user/showMsg")
    public String showMsg() {
        log.info("调用用户服务...");
        // 1. 使用 restTemplate 调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        // 参数 1：请求路径
        // 参数 2：返回值类型
        String forObject = restTemplate.getForObject("http://localhost:9998/product/showMsg", String.class);
        return forObject;
    }

    // http://localhost:9999/user/findAll
    @GetMapping("/user/findAll")
    public String findAll() {
        log.info("调用用户服务...");
        // 1. 使用 restTemplate 调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        // 参数 1：请求路径
        // 参数 2：返回值类型
        String forObject = restTemplate.getForObject("http://localhost:9998/product/findAll", String.class);
        return forObject;
    }
}
