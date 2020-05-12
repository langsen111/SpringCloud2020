package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author harry
 * @create 2020-05-12 13:48
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerExcepiton(BlockException exception){

        return new CommonResult(444, "按客户自定义，global handler Exception----1");
    }

    public static CommonResult handlerExcepiton2(BlockException exception){

        return new CommonResult(444, "按客户自定义，global handler Exception------2");
    }
}
