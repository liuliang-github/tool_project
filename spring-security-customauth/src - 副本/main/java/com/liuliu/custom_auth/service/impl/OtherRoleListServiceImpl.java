package com.liuliu.custom_auth.service.impl;

import com.liuliu.custom_auth.service.OtherRoleListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LL
 * @date 2022/7/6 19:13
 * @Description
 */
@Service
public class OtherRoleListServiceImpl implements OtherRoleListService {
    public List<String> getRolesByUsername(String username){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("admin");
        return strings;

    }
}
