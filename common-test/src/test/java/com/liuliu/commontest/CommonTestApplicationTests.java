package com.liuliu.commontest;

import com.liuliu.common_util.configs.PropertiesConfig;
import com.liuliu.common_util.globalexception.CustomException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class CommonTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testProperties() throws Exception {
        Properties instance = PropertiesConfig.getInstance();
        System.out.println(instance.getProperty("port"));
    }

}
