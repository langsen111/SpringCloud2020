package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author harry
 * @create 2020-04-03 15:06
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced  // 使用@LoakBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }  //LoadBalanced 负载均衡能力
}

//applicationContest.xml <bean id = "" calss=""> 将RestTemplate对象注册到容器中