package com.liuliu.common_util.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author LL
 * @date 2022/6/9 20:56
 * @Description 凡是继承该接⼝的类，在初始化bean的时候都会执⾏afterPropertiesSet()⽅法。
 */
@Configuration
public class AutoLoadProfile implements InitializingBean {

    @Value("${server.port}")
    private String port;

    public static String PORT_STATIC;

    /**
     * 在初始化bean后，执行
     *  spring初始化目前有三种方式
     *      1.实现InitializingBean接口，继而实现afterPropertiesSet的方法
     *      2.反射原理，配置文件使用init-method标签直接注入bean
     *      <bean id="initMethodBean" class="com.InitRuleBean" init-method="initMethod"></bean>
     *      3.@PostConstruct注解
     *      Constructor（构造器） > @PostConstruct > InitializingBean > init-method
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        PORT_STATIC=this.port;
        System.out.println(PORT_STATIC);
    }
}
