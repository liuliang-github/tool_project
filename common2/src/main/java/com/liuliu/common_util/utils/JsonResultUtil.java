package com.liuliu.common_util.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LL
 * @date 2022/6/8 22:00
 * @Description 统一数据返回类型
 */
@Data
public class JsonResultUtil {
    //私有化构造，禁止创建对象
    private JsonResultUtil(){}

    private String message;//请求结果描述
    private Integer code;//状态码
    private Boolean success;//状态
    private Map<String,Object> data = new HashMap<>();//结果集

    //请求成功响应
    public static JsonResultUtil ok(){
        JsonResultUtil res = new JsonResultUtil();
        res.setSuccess(true);
        res.setCode(CodeStatus.SUCCESS);
        res.setMessage("成功");

        return res;
    }

    //请求失败响应
    public static JsonResultUtil error(){
        JsonResultUtil res = new JsonResultUtil();
        res.setSuccess(false);
        res.setCode(CodeStatus.ERROR);
        res.setMessage("失败");

        return res;
    }

    //链式编程
    public JsonResultUtil data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public JsonResultUtil data(Map<String,Object> val){
        this.setData(val);
        return this;
    }

    public JsonResultUtil code(Integer code){
        this.setCode(code);
        return this;
    }

    public JsonResultUtil success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public JsonResultUtil message(String message){
        this.setMessage(message);
        return this;
    }
}
