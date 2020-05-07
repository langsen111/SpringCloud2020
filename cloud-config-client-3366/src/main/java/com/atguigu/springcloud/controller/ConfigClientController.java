package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harry
 * @create 2020-04-14 14:51
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configINfo;  // 要访问的3344上的信息

    @GetMapping("/configInfo")  // 请求地址
    public String getConfigINfo(){
        return "serverPort: "+serverPort + "\t\n\n configInfo: " + configINfo;
    }


}
