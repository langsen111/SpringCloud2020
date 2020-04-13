package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author harry
 * @create 2020-04-10 16:38
 * @Version 1.0
 */
@Service
public class PaymentService {

    public String paymentInfo_Ok(Integer id){
        return "线程池" + Thread.currentThread().getName() + "   paymentInfo_Ok, id: "+ id + "\t" + "😄哈哈～";
    }

    /**
     * http://localhost:8001/payment/hystrix/timeout/31
     * @HystrixCommand报异常后如何处理：
     * 一旦调用服务方法失败并抛出了错误信息后，
     * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //设置这个线程的超时时间是5s，5s内是正常的业务逻辑，超过5s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){

//        int age = 10 / 0;

        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "   paymentInfo_TimeOut, id: "+ id + "\t" + "😄哈哈～"+"   耗时(秒)："+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池"+ Thread.currentThread().getName() + "  8001系统繁忙， 请稍后再试， id : " + id +"\t" +"😣gg～～";
    }


    // ======服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id < 0){
            throw new RuntimeException("***********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "invoke success, 流水号： "+ serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){

        return "id 不能为负数， 请稍后再试， /😣😣～～ id: " + id;
    }
}
