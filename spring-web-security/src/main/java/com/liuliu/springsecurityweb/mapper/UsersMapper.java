package com.liuliu.springsecurityweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuliu.springsecurityweb.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
