package com.auth.controller;

import com.auth.entity.User;
import com.auth.service.UserService;
import com.auth.utils.JWTUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        log.info("Username: [{}]", user.getName());
        log.info("Password: [{}]", user.getPassword());
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            // get token
            Map<String, String> payload = new HashMap<>();
            payload.put("name", userDB.getName());
            String token = JWTUtils.generateToken(payload);
            map.put("state", true);
            map.put("msg", "login successful");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", "Wrong Username or Password");
        }
        return map;
    }

    @PostMapping("/token/verify")
    public Map<String, Object> verify(String token) {
        log.info("Received Token: [{}]", token);
        Map<String, Object> map = new HashMap<>();
        try {
            DecodedJWT decodedJWT = JWTUtils.verifyToken(token);
            map.put("state", true);
            map.put("name", decodedJWT.getClaim("name").asString());
            map.put("msg", "token is OK");
            map.put("status", "00");
            return map;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "invalid signature detected");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token is expired");
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            map.put("msg", "token is modified");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "algorithm mismatch");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token verify failed");
        }
        map.put("status", "01");
        return map;
    }

    @PostMapping("/token/verifybyheader")
    public Map<String, Object> verify(HttpServletRequest request) {
        String token = request.getHeader("token");
        log.info("Received Token: [{}]", token);
        Map<String, Object> map = new HashMap<>();
        try {
            DecodedJWT decodedJWT = JWTUtils.verifyToken(token);
            map.put("state", true);
            map.put("name", decodedJWT.getClaim("name").asString());
            map.put("msg", "token is OK");
            map.put("status", "00");
            return map;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "invalid signature detected");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token is expired");
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            map.put("msg", "token is modified");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "algorithm mismatch");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token verify failed");
        }
        map.put("status", "01");
        return map;
    }
}