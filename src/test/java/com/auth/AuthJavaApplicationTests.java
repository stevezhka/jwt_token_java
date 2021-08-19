package com.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

//@SpringBootTest
class AuthJavaApplicationTests {

    @Test
    void contextLoads() {

        HashMap<String, Object> map =  new HashMap<>();

        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.HOUR, 2);
        instance.add(Calendar.SECOND, 5);
        // generate token
        String token = JWT.create()
//                .withHeader(map)
//                .withClaim("name", 12)
                .withClaim("username", "bob")
                .withExpiresAt(instance.getTime())
//                .sign(Algorithm.HMAC256("mytoken!&U*&$#*&WRS")); // signature
                .sign(Algorithm.HMAC256("sgka!7@^#rfdWWidfdfdsjjiiojfweddfdkljfie792888df793ffds*(*90su")); // signature
        // output token
        System.out.println(token);
//        String token2 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjkxODIzNjksInVzZXJuYW1lIjoiZ3JlYXRNYXN0ZXIifQ.6KsIjp-YVo5l6vTm-hxTr1eBziFln6wwk7qWTG8siL0";
//        System.out.println("decode token -------------");
//        System.out.print(JWT.decode(token));
    }

//    @Test
//    public void test(){
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("mytoken!&U*&$#*&WRS")).build();
//        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjkxOTA3MjksInVzZXJpZCI6IjAwMSIsInVzZXJuYW1lIjoiZ3JlYXRNYXN0ZXIifQ.WQTVIHMib1u7BD2mkcGG4sWfZL_yilNxEc7S3t4X_IA");
////        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjkxODIzNjksInVzZXJuYW1lIjoiZ3JlYXRNYXN0ZXIifQ.6KsIjp-YVo5l6vTm-hxTr1eBziFln6wwk7qWTG8siL0");
////        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjkxOTEwMTYsInVzZXJpZCI6MTIsInVzZXJuYW1lIjoiZ3JlYXRNYXN0ZXIifQ.qDWXXUTDWofiFMtoB83SDFIatqehHwF_QmCByQ_82Nc");
//
//
//        System.out.println(decodedJWT.getClaim("userid"));
//        System.out.println(decodedJWT.getClaim("username"));
//        System.out.println("Expire time : "+decodedJWT.getExpiresAt());
//    }

}
