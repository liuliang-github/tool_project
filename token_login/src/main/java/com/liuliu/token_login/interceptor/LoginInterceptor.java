package com.liuliu.token_login.interceptor;

import com.liuliu.common_util.globalexception.CustomException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LL
 * @date 2022/6/11 23:30
 * @Description
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (null == cookies){
            throw new CustomException("请登录");
        }

        String token = "";
        for (Cookie cookie : cookies) {
            if ("isLogin".equals(cookie.getName())){
                String value = cookie.getValue();
                 token = (String) redisTemplate.opsForValue().get(value);
                 break;
            }
        }
        if (StringUtils.isNotBlank(token)){
            return true;
        }

        throw new CustomException("登录失效，请重新登录");

    }
}
