package com.liuliu.commontest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuliu.commontest.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LL
 * @date 2022/7/2 18:00
 * @Description
 */
@Mapper
@Repository
public interface UsersDao extends BaseMapper<Users> {
}
