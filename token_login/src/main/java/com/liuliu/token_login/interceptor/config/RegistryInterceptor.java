package com.liuliu.token_login.interceptor.config;

import com.liuliu.token_login.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LL
 * @date 2022/6/11 23:33
 * @Description
 */
@Configuration
public class RegistryInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor());
        interceptor.addPathPatterns("/**");//拦截所有请求
        //添加不拦截路径
        interceptor.excludePathPatterns("/login",
                "/**/*.html", //html静态资源
                "/**/*.js", //js静态资源
                "/**/*.css" //css静态资源
        );
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }


}
