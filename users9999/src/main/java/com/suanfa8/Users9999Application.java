package com.suanfa8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 开启 openfeign 支持
@EnableFeignClients
public class Users9999Application {

    public static void main(String[] args) {
        SpringApplication.run(Users9999Application.class, args);
    }

}
