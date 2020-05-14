package com.atguigu.springcloud.alibaba.service;

/**
 * @author harry
 * @create 2020-05-14 15:19
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId,Integer count);
}
