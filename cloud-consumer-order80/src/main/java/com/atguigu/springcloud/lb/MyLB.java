package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ribbon 手写轮询算法
 * @author harry
 * @create 2020-04-10 14:16
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalancer{

    // 原子类
    private AtomicInteger  atomicInteger = new AtomicInteger(0);


    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            // 超过最大值 为0，重新计数2147483647  Integer.MXA_VALUE
            next = current >= 2147483647 ? 0 : current + 1;
            // 自旋锁
        }while(!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问 次数*next: "+ next);
        return next;
    }

    // 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标， 每次服务重新启动后rest接口计数从1开始。
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances){

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}


