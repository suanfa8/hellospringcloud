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
        log.info("商品服务查询所有调用成功,当前服务端口:[{}]", port);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "服务调用成功,服务提供端口为: " + port);
        map.put("status", true);
        return map;
    }


}
