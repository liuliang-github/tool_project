package com.liuliu.common_util.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author LL
 * @date 2022/7/2 21:09
 * @Description 类加载机制进行获取配置文件。
 */
@Slf4j
public class PropertiesConfig {
    private static Properties properties;
    private PropertiesConfig() {}
    public static Properties getInstance() throws Exception{
        synchronized(Properties.class) {
            if (properties == null) {
                properties = new Properties();
                try (InputStream in = PropertiesConfig.class.getClassLoader().getResourceAsStream("tete.txt")) {
                    properties.load(in);
                } catch (Exception e) {
                    log.error("获取配置文件异常： {}", e.getMessage());
                }
            }
        }
        return properties;
    }
}
