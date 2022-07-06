package com.liuliu.commontest.service;

import com.liuliu.commontest.entity.Users;

import java.util.List;

/**
 * @author LL
 * @date 2022/7/2 18:16
 * @Description
 */
public interface CacheService {
    List<Users> testCacheServer();
    List<Users> updateUser();
    int deleteUser();
}
