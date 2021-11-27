package com.suanfa8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Configserver7878Application {

    public static void main(String[] args) {
        SpringApplication.run(Configserver7878Application.class, args);
    }

}
