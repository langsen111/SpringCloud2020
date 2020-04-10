//Json封装体CommentResult,传给前端，判断编码是否成功，成功才显示
package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;
    private String message;
    private T data;

    public  CommonResult(Integer code, String message){  //泛型：如果装的payment 返回payment,装的order 返回order

        this(code, message, null);
    }

}