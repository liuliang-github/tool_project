package com.liuliu.custom_auth.controller;

import com.liuliu.common_util.utils.JsonResultUtil;
import com.liuliu.custom_auth.entity.Users;
import com.liuliu.custom_auth.service.OtherLoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LL
 * @date 2022/7/6 18:49
 * @Description
 */
@RestController
@RequestMapping("/user/auth")
public class LoginOtherController {
    @Autowired
    OtherLoginService otherLoginService;

    @PostMapping("/login")
    public JsonResultUtil login(@RequestBody Users users){
        String token = otherLoginService.login(users);

        if (StringUtils.isBlank(token)){
            return JsonResultUtil.error().message("登录失败");
        }

        return JsonResultUtil.ok().data("token",token);
    }
}
