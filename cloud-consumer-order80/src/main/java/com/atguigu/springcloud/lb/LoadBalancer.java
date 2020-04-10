package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 模拟ILoadBalancer的接口，选择哪一个负载算法和机器
 * @author harry
 * @create 2020-04-10 14:13
 * @Version 1.0
 */

public interface LoadBalancer {

    // 获取eureka上活着的机器总数
    ServiceInstance instances(List<ServiceInstance> serviceInstance);
}
