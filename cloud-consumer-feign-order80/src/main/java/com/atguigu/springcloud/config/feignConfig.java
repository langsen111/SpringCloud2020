package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author harry
 * @create 2020-04-10 16:04
 * @Version 1.0
 */
@Configuration
public class feignConfig {

    @Bean
    Logger.Level feignLoogerLevel(){
        return Logger.Level.FULL;
    }
}
