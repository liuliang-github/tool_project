package com.liuliu.commontest.controller;

import com.liuliu.common_util.globalexception.CustomException;
import com.liuliu.common_util.utils.JsonResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LL
 * @date 2022/6/9 21:16
 * @Description
 */
@RestController
@Slf4j
public class testController {
    @GetMapping("/test")
    public JsonResultUtil test(HttpServletRequest request, HttpServletResponse response,@RequestParam String name){
        return JsonResultUtil.ok();
    }

    @GetMapping("/testException")
    public JsonResultUtil testException(){
//        throw new CustomException("测试1");
        throw new CustomException(111,"eeeee");
    }}
