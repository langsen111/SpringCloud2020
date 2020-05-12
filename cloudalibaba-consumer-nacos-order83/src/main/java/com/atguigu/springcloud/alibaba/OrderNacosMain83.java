package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author harry
 * @create 2020-05-09 17:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {

    public static void main(String[] args){

        SpringApplication.run(OrderNacosMain83.class, args);
    }
}
