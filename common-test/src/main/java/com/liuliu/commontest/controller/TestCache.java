package com.liuliu.commontest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuliu.common_util.utils.JsonResultUtil;
import com.liuliu.commontest.dao.UsersDao;
import com.liuliu.commontest.entity.Users;
import com.liuliu.commontest.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author LL
 * @date 2022/7/2 17:47
 * @Description  spring缓存
 */
@RestController
@CacheConfig(cacheNames = {"test1"})
public class TestCache {

    @Autowired
    CacheService cacheService;

    @GetMapping("/testCache1")
    public JsonResultUtil testCache1(){
        return JsonResultUtil.ok().data("te",cacheService.testCacheServer());
    }

    @GetMapping("/testCache2")
    public JsonResultUtil testCache2(){
        return JsonResultUtil.ok().data("te",cacheService.updateUser());
    }

    @GetMapping("/testCache3")
    public JsonResultUtil testCache3(){
        return JsonResultUtil.ok().data("te",cacheService.deleteUser());
    }
}
