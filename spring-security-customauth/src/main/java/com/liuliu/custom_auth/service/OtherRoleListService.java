package com.liuliu.custom_auth.service;

import java.util.List;

/**
 * @author LL
 * @date 2022/7/6 19:12
 * @Description
 */
public interface OtherRoleListService {
    List<String> getRolesByUsername(String username);

}
