package com.liuliu.custom_auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuliu.custom_auth.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
