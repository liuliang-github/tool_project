package com.liuliu.custom_auth.security.filter;

import com.liuliu.common_util.utils.JsonResultUtil;
import com.liuliu.common_util.utils.JwtUtil;
import com.liuliu.common_util.utils.ResponseUtil;
import com.liuliu.custom_auth.entity.security.JwtUser;
import com.liuliu.custom_auth.entity.security.User;
import com.liuliu.custom_auth.service.OtherRoleListService;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LL
 * @date 2022/7/3 0:46
 * @Description 访问拦截 ，每次请求只过一次
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    OtherRoleListService otherRoleListService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //获取token
        String token = request.getHeader("token");

        if (StringUtils.isBlank(token)){
            //校验token
            boolean flag = JwtUtil.checkToken1(token);
            //生成权限
            if (flag){

                String userNameByToken = JwtUtil.getUserNameByToken(token);
                List<String> roles = otherRoleListService.getRolesByUsername(userNameByToken);

                User user = new User();
                user.setUsername(userNameByToken);
                JwtUser jwtUser = new JwtUser(user);
                jwtUser.setPermissionValueList(roles);


                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(
                                jwtUser, null, jwtUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);

            } else {
                ResponseUtil.out(response, JsonResultUtil.error().message("登录过期，请重新登录"));
            }
        }

        //放行
        filterChain.doFilter(request, response);
    }
}
