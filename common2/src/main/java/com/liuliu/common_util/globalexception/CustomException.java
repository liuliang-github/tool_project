package com.liuliu.common_util.globalexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LL
 * @date 2022/6/8 22:05
 * @Description 自定义异常处理
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
     private Integer code;
     private String message;

    public CustomException(String message){
        this.message = message;
    }

}
