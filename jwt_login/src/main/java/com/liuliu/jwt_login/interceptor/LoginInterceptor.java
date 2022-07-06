package com.liuliu.jwt_login.interceptor;

import com.liuliu.common_util.globalexception.CustomException;
import com.liuliu.common_util.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (null == cookies){
            throw new CustomException("请登录");
        }

        String token = "";
        for (Cookie cookie : cookies) {
            if ("isLogin".equals(cookie.getName())){
                token = cookie.getValue();
                break;
            }
        }
        if(StringUtils.isNotBlank(token)){
            Claims claims = JwtUtil.checkToken(token);
            if (null != claims){
                return true;
            }
        }

        throw new CustomException("登录失效，请重新登录");

    }
}
