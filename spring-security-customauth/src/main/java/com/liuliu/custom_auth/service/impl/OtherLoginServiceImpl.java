package com.liuliu.custom_auth.service.impl;

import com.liuliu.common_util.globalexception.CustomException;
import com.liuliu.common_util.utils.JwtUtil;
import com.liuliu.custom_auth.entity.Users;
import com.liuliu.custom_auth.service.OtherLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Security;

/**
 * @author LL
 * @date 2022/7/6 18:53
 * @Description
 */
@Service
public class OtherLoginServiceImpl implements OtherLoginService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public String login(Users users) {
        String username = users.getUsername();
        String password = users.getPassword();
        if (username == null || password == null){
            throw new CustomException("用户名和密码均不能为null");
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //放入上下文
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        String name = authenticate.getName();
        String token = JwtUtil.getToken(name, "1");
        //查询权限，并放入redis， key == token
        //TODO
        return token;
    }
}
