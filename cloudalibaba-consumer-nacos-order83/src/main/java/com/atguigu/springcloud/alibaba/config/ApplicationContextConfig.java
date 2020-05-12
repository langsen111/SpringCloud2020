package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Nacos 自带Ribbon， 引入RestTemplate
/**
 * @author harry
 * @create 2020-05-09 17:16
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced  // RestTemplate结合Ribbon做负载均衡一定要加@LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
