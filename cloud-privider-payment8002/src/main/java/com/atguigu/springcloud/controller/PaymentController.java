package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author harry
 * @create 2020-04-03 11:17
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverProt;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("****插入结果: "+result);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功, serverProt: "+ serverProt, result);
        }else{
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        System.out.println(id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果: "+payment + "\t"+ "😄");

        if(payment != null){
            return new CommonResult(200, "查询成功, serverProt: "+ serverProt, payment);
        }else{
            return new CommonResult(444, "没有对应的记录,查询ID："+id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("*******element: "+ element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){

        return serverProt;
    }
}
