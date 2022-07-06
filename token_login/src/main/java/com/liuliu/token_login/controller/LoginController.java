package com.liuliu.token_login.controller;

import com.liuliu.common_util.utils.JsonResultUtil;
import com.liuliu.common_util.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author LL
 * @date 2022/6/11 21:42
 * @Description
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/login")
    public JsonResultUtil login(HttpServletRequest request, HttpServletResponse response,String name,String password){
        if ("admin".equals(name) && "123456".equals(password)){
            String simpleUUID = UuidUtil.getSimpleUUID();

            Cookie cookie = new Cookie("isLogin", simpleUUID);
            cookie.setPath("/");
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);

            redisTemplate.opsForValue().set(simpleUUID,"yes",30*60, TimeUnit.SECONDS);

            return JsonResultUtil.ok().message("登录成功");
        }
        return JsonResultUtil.error().message("账号或密码错误，请检查后重新登录");
    }

    @GetMapping("/test")
    public JsonResultUtil test(){
       return JsonResultUtil.ok();
    }
}
