package com.yx.demo.util;

import com.yx.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {
    public static final String SUBJECT = "yx_subject";
    public static final long EXPIRE = 1000 * 60 * 15; //过期时间
    public static final String APPSECRECT = "yx_appsecrect";


    public static String genJWT(User user){
        if(user.getName() == null || user.getPassword() == null){
            return null;
        }
        final String token = Jwts.builder().setSubject(SUBJECT)
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRECT).compact();
        return token;
    }

    public static Claims checkJWT(String token){
        final Claims claims = Jwts.parser().setSigningKey(APPSECRECT)
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
