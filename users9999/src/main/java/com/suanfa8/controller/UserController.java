package com.suanfa8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

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
    @GetMapping("/user/findAll2")
    public String findAll2() {
        log.info("调用用户服务...");
        // 1. 使用 restTemplate 调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        // 参数 1：请求路径
        // 参数 2：返回值类型
        String forObject = restTemplate.getForObject("http://localhost:9998/product/findAll", String.class);
        return forObject;
    }

    // http://localhost:9999/user/findAll
    @GetMapping("/user/findAll3")
    public List<ServiceInstance> findAll3() {
        log.info("调用用户服务...");
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("products");
        for (ServiceInstance serviceInstance : serviceInstances) {
            log.info("服务主机:[{}]", serviceInstance.getHost());
            log.info("服务端口:[{}]", serviceInstance.getPort());
            log.info("服务地址:[{}]", serviceInstance.getUri());
            log.info("====================================");
        }
        return serviceInstances;
    }

    // http://localhost:9999/user/findAll
    @GetMapping("/user/findAll4")
    public ServiceInstance findAll4() {
        log.info("调用用户服务...");

        // 实现了「负载均衡」
        ServiceInstance products = loadBalancerClient.choose("products");
        log.info("服务主机:[{}]", products.getHost());
        log.info("服务端口:[{}]", products.getPort());
        log.info("服务地址:[{}]", products.getUri());

        // 然后再使用 RestTemplate 去拼接，但是这种方式也不好，所以我们在 RestTemplate 的配置的时候，加上一个注解 @LoadBalanced
        return products;
    }

    // http://localhost:9999/user/findAll
    @GetMapping("/user/findAll")
    public String findAll() {
        log.info("调用用户服务...");
        // 这里 products 是配置的服务端的名称
        String forObject = restTemplate.getForObject("http://products/product/findAll", String.class);
        return forObject;
    }
}
