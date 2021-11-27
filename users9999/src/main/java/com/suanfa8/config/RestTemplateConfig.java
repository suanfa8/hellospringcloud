package com.suanfa8.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 在工厂中创建一个 RestTemplateConfig 对象
     *
     * @return
     */
    @Bean
    @LoadBalanced
    // 代表 Ribbon 负载均衡的 RestTemplateConfig 客户端对象
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
