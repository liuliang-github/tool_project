package com.liuliu.common_util.utils;

import java.util.UUID;

/**
 * @author LL
 * @date 2022/6/10 21:57
 * @Description
 */
public class UuidUtil {

    /**
     * 创建一个随机的UUID
     * @return
     */
    public static String getRandomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 创建一个去除‘-’的UUID
     * @return
     */
    public static String getSimpleUUID(){
        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
        return replace;
    }

}
