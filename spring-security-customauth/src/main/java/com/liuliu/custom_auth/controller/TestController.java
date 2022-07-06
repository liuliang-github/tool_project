package com.liuliu.custom_auth.controller;

import com.liuliu.common_util.utils.JsonResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LL
 * @date 2022/6/27 22:57
 * @Description
 */
@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("/hello")
    public JsonResultUtil hello(){
        return JsonResultUtil.ok().message("hello security");
    }
}
