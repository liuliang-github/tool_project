package com.liuliu.commontest.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LL
 * @date 2022/6/9 21:09
 * @Description
 */
@Configuration
@ComponentScan("com.liuliu")
//@MapperScan("com.liuliu.commontest.dao")
public class CommonConfig {
}
