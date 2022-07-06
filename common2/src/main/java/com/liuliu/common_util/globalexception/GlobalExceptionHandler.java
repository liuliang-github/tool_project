package com.liuliu.common_util.globalexception;

import com.liuliu.common_util.utils.JsonResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LL
 * @date 2022/6/8 22:06
 * @Description 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //自定一异常
    @ExceptionHandler(CustomException.class)
    public JsonResultUtil customExceptionHand(CustomException e){
        log.error("",e);
        if (e.getCode() == null){
            return JsonResultUtil.error().message(e.getMessage());
        }
        return JsonResultUtil.error().message(e.getMessage()).code(e.getCode());
    }

    //拦截运行是异常
    @ExceptionHandler(RuntimeException.class)
    public JsonResultUtil globalExceptionHand(Exception e){
        log.error("",e);
        return JsonResultUtil.error().message("未知错误，请检查重试");
    }

    //错误
    @ExceptionHandler(Throwable.class)
    public JsonResultUtil systemExceptionHand(Throwable th){
        log.error("",th);
        return JsonResultUtil.error().message("系统异常，请稍后");
    }

}
