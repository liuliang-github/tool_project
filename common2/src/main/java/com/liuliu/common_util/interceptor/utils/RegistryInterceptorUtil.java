package com.liuliu.common_util.interceptor.utils;

import com.liuliu.common_util.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LL
 * @date 2022/6/10 21:46
 * @Description 注册拦截器，通过创建对象的形式（另一种是通过注入bean的形式）
 */
//@Configuration
public class RegistryInterceptorUtil implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
        interceptor.addPathPatterns("/**");//拦截所有请求
        //添加不拦截路径
        interceptor.excludePathPatterns("/login",
                "/**/*.html", //html静态资源
                "/**/*.js", //js静态资源
                "/**/*.css" //css静态资源
        );
    }

    //方法二
//    @Bean
//    public LoginInterceptor loginInterceptor(){
//        return new LoginInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor());
//    }
}
