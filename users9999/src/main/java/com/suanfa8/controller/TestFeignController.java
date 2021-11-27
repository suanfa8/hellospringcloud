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
    public String showMsg() {
        log.info("进入测试 feign 调用的方法....");
        String msg = productClient.showMsg();
        log.info("调用商品服务返回的信息: [{}]", msg);
        return msg;
    }

    // http://localhost:9999/feign/test/findAll
    @GetMapping("/feign/test/findAll")
    public Map<String, Object> findAll() {
        log.info("进入测试 feign 调用的方法....");
        Map<String, Object> map = productClient.findAll();
        log.info("调用商品服务返回的信息: [{}]", map);
        return map;
    }

    // http://localhost:9999/feign/test1?id=1419
    @GetMapping("/feign/test1")
    public Map<String, Object> test1(String id) {
        log.info("用来测试 Openfiegn 的 GET 方式参数传递");
        Map<String, Object> msg = productClient.findOne(id);
        log.info("调用返回信息：[{}]", msg);
        return msg;
    }
}
