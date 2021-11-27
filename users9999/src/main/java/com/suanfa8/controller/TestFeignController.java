package com.suanfa8.controller;

import com.suanfa8.clients.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TestFeignController {

    @Autowired
    private ProductClient productClient;

    // http://localhost:9999/feign/test/showMsg
    @GetMapping("/feign/test/showMsg")
    public String showMsg(){
        log.info("进入测试 feign 调用的方法....");
        String msg = productClient.showMsg();
        log.info("调用商品服务返回的信息: [{}]", msg);
        return msg;
    }

    // http://localhost:9999/feign/test/findAll
    @GetMapping("/feign/test/findAll")
    public Map<String, Object> findAll(){
        log.info("进入测试 feign 调用的方法....");
        Map<String, Object> map = productClient.findAll();
        log.info("调用商品服务返回的信息: [{}]", map);
        return map;
    }
}
