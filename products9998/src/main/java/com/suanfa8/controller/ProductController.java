package com.suanfa8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

    // http://localhost:9998/product/showMsg
    @GetMapping("/product/showMsg")
    public String showMsg() {
        log.info("进入商品服务，展示商品");
        return "进入商品服务，展示商品 " + port;
    }

    // http://localhost:9998/product/findAll
    @GetMapping("/product/findAll")
    public Map<String, Object> findAll() {
        log.info("商品服务查询所有调用成功，当前服务端口:[{}]", port);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "服务调用成功，服务提供端口为: " + port);
        map.put("status", true);
        return map;
    }

    @GetMapping("/product/findOne")
    public Map<String, Object> findOne(String productId) {
        log.info("商品服务查询商品信息调用成功，当前服务端口：[{}]", port);
        log.info("当前接收商品信息的 id：[{}]", productId);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "商品服务查询商品信息调用成功，当前服务端口: " + port);
        map.put("status", true);
        map.put("productId", productId);
        return map;
    }
}
