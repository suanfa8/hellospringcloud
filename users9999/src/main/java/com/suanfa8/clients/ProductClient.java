package com.suanfa8.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "products")
public interface ProductClient {

    @GetMapping("/product/showMsg")
    public String showMsg();

    @GetMapping("/product/findAll")
    public Map<String, Object> findAll();

    @GetMapping("/product/findOne")
    Map<String, Object>  findOne(@RequestParam("productId") String productId);
}
