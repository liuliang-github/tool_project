package com.liuliu.session_login.interceptor;

import com.liuliu.common_util.globalexception.CustomException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LL
 * @date 2022/6/10 21:44
 * @Description
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        String requestURI = request.getRequestURI();
        String  isLogin = (String) request.getSession().getAttribute("isLogin");
        if (null != isLogin){
            return true;
        }
        throw new CustomException("登录过期，请重新登录");
    }
}

