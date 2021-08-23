package com.auth.controller;

import com.alibaba.druid.util.StringUtils;
import com.auth.entity.User;
import com.auth.service.UserService;
import com.auth.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${auth.jwt.signature}")
    private String SIGNATURE;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("uname"));
        user.setPassword(request.getParameter("upwd"));
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            return "login";
        }
        log.info("Username: [{}]", user.getName());
        log.info("Password: [{}]", user.getPassword());
        try {
            User userDB = userService.login(user);
            // get token
            Map<String, String> payload = new HashMap<>();
            payload.put("name", userDB.getName());
            String token = JWTUtils.generateToken(payload, SIGNATURE);
            response.addHeader("state", "true");
            response.addHeader("msg", "token generated successful");
            response.addHeader("token", token);
            return "finished";
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Wrong Username or Password");
        }
        return "login";
    }
}