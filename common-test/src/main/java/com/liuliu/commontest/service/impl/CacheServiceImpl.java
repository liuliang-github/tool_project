package com.liuliu.commontest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuliu.commontest.dao.UsersDao;
import com.liuliu.commontest.entity.Users;
import com.liuliu.commontest.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LL
 * @date 2022/7/2 18:17
 * @Description
 */
@Service
public class CacheServiceImpl implements CacheService {
    @Autowired
    UsersDao usersDao;
    /**
     * @Cacheable：进行缓存
     * @Cacheable的几个属性：
     * cacheNames/value：指定缓存组件的名字；将方法的返回结果放入缓存中，是数组的方式，可以指定多个缓存
     * key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值
     * keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     * key/keyGenerator二选一使用
     * cacheManager：指定缓存管理器，或者cacheResolver指定获取解析器
     * condition：指定符合条件的情况下才缓存
     * unless：否定缓存，当unless指定的条件为true，方法的换回值就不会被缓存，可以获取到结果进行判断
     * sync：是否使用异步模式
     * @return
     */
    @Cacheable(cacheNames = "employee",key = "'test'")
    public List<Users> testCacheServer(){

        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username","liu");

        List<Users> users = usersDao.selectList(wrapper);
        return users;
    }

    /**
     * @CachePut：既调用方法也更新缓存数据
     * 原理：先更新内容，然后把结果更新缓存
     * 要指定好key
     * @return
     */
    @CachePut(value = "employee",key = "")
    @Override
    public List<Users> updateUser() {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username","liu");

        List<Users> users = usersDao.selectList(wrapper);
        return users;
    }

    /**
     * 缓存清除
     * key：指定要清除的数据
     * allEntries = true：指定清除这个缓存中的所有数据
     * beforeInvocation = false：缓存的清除是否在方法之前执行
     * @return
     */
//    @CacheEvict(value = "employee") //清楚所有的缓存
    @CacheEvict(value = "employee",key = "'test'") //清除指定缓存的指定key的缓存
    @Override
    public int deleteUser() {
        return 1;
    }
}
