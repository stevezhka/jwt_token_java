package com.auth.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static String SIGNATURE = "sgka!7@^#rfdWWidfdfdsjjiiojfweddfdkljfie792888df793ffds*(*90su";

    /**
     * generate token
     * @param map //param payload
     * @return token
     */
    public static String generateToken(Map<String, String> map){
        JWTCreator.Builder builder = JWT.create();
        // set payload
        map.forEach((k, v)->{
            builder.withClaim(k, v);
        });
        Calendar calendar = Calendar.getInstance();
        // expire after 7 days
        calendar.add(Calendar.DATE, 7);
        builder.withExpiresAt(calendar.getTime());
        return builder.sign(Algorithm.HMAC256(SIGNATURE));
    }

    /**
     * verify token
     * @param token
     * @return DecodedJWT
     */
    public static DecodedJWT verifyToken(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
