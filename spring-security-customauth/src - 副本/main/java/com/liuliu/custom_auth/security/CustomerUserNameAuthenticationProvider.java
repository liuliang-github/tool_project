package com.liuliu.custom_auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;

/**
 * @author LL
 * @date 2022/6/27 23:12
 * @Description 第三方认证（自定义认证方式）
 */
@Component
public class CustomerUserNameAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserDetailsService userDetailsService;
    //身份认证 用户名和密码的校验
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName =authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
//        String userNameDB = "w";
//        String passwordDB = "$2a$10$bNLsh/QX6.qYAjapVbtOT.MEfz.o70xxPxpIAHNU/BEEJQWasHcR2";
        String userNameDB = userDetails.getUsername();
        String passwordDB = userDetails.getPassword();//"$2a$10$bNLsh/QX6.qYAjapVbtOT.MEfz.o70xxPxpIAHNU/BEEJQWasHcR2";//"123456";

        boolean isPassword = BCrypt.checkpw(password,passwordDB);

        if (userName.equals(userNameDB) && isPassword){
            return new UsernamePasswordAuthenticationToken(userName,password,new ArrayList<>());
        }else {
            throw new BadCredentialsException("Invalid username / password");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String password = encoder.encode("123456");
//        System.out.println(password);
//    }
}
