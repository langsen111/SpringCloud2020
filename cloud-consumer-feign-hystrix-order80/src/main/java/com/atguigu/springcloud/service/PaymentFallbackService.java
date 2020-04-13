package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author harry
 * @create 2020-04-13 11:38
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id){
        return "-----PaymentFallbackService fall back-paymentINfo_OK, sad~~!";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id){
        return "-----PaymentFallbackService fall back-paymentINfo_TimeOut, @(#~#`)~";
    }
}
