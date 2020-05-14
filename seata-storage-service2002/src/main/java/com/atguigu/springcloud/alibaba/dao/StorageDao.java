package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author harry
 * @create 2020-05-14 15:17
 * @Version 1.0
 */
@Mapper
public interface StorageDao {

    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
