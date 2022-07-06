package com.liuliu.custom_auth.security;

import com.liuliu.common_util.globalexception.CustomException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author LL
 * @date 2022/7/3 0:17
 * @Description 自定义其他方式进行认证
 */
@Component
public class CustomerOtherAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName =authentication.getName();
        String password = authentication.getCredentials().toString();

        if (userName.isEmpty() || password.isEmpty()){
            throw new CustomException("用户名或密码不能为空");
        }

        //第三方进行认证
        //模拟三方认证
        if (true){
            return new UsernamePasswordAuthenticationToken(userName,password);
        }else {
            throw new BadCredentialsException("Invalid username / password");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
