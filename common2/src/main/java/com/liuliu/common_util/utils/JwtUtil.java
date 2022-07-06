package com.liuliu.common_util.utils;

import com.liuliu.common_util.globalexception.CustomException;
import io.jsonwebtoken.*;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * @author LL
 * @date 2022/6/10 21:57
 * @Description JWT登录验证，token 生成与校验
 */
public class JwtUtil {
    /**
     * 两个常量： 过期时间 ，密钥
     */
    public static final long EXPIRE = 1000*30*60;
    public static final String SECRET = "uwryfhHsKlBvLPPss093n";

    /**
     * 创建jwt 的token
     * @param name
     * @param id
     * @return
     */
    public static String getToken(String name,String id){
        String JwtToken = Jwts.builder()
                //JWT头信息
//                .setHeaderParam("typ", "JWT")
//                .setHeaderParam("alg", "HS2256") //base64解密token会乱码
                //设置分类；设置过期时间 一个当前时间，一个加上设置的过期时间常量
                .setSubject(String.format("test.%s",name))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置token主体信息，存储用户信息
                .claim("id", id)
                .claim("userName" , name)
                //.signWith(SignatureAlgorithm.ES256, SECRET)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return JwtToken;
    }

    public static Claims checkToken(String token){
        if (StringUtils.isBlank(token)){
            throw new CustomException("登录验证失败，请重新登录");
        }

        try {
            Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return body;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            throw new CustomException("登录验证失效，请重新登录");

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("登录验证失败，请重新登录");
        }
    }

    public static boolean checkToken1(String token){
        if (StringUtils.isBlank(token)){
            return false;
//            throw new CustomException("登录验证失败，请重新登录");
        }

        try {
            Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据token得到username
     * @param token
     * @return
     */
    public static String getUserNameByToken(String token){
        Claims body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
        Object userName = body.get("userName");
        return (String)userName;
    }


}
