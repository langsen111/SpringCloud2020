package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author harry
 * @create 2020-04-10 15:25
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients  // 开启Feign
public class OrderFeignMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
