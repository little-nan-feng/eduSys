package com.nanfeng.utils;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;


@Data
@ConfigurationProperties(prefix = "jwt.token")
@Component
public class JwtHelper {

    private long tokenExpiration;
    private String tokenSignKey;

    //生成token字符串
    public String createToken(String UserId){

        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration * 1000*60*60*24))
                .claim("UserId",UserId)
                .signWith(SignatureAlgorithm.HS512,tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    //解析token字符串，获取UserId
    public String getUserId(String token){

        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String userId = (String) claims.get("UserId");
        return userId;
    }

    //查看token是否过期
    public boolean checkToken(String token){
        try {
            boolean isExpired = Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration()
                    .before(new Date());
            //没有过期，直接返回 false
            return isExpired;
        }catch (Exception e)
        {
            //过期返回异常
            return true;
        }
    }
}
