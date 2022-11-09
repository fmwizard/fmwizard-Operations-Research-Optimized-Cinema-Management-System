package com.example.ticket.controller.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.response.ResponseData;
import com.example.ticket.controller.BaseController;

import com.example.ticket.entity.User;
import com.example.ticket.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseData getAll(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        List<User> users = userService.list(queryWrapper);

        return result(users);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody User user) {

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getPhone(), user.getPassword());

        try {
            subject.login(token); // 执行登录方法
            User u = userService.queryUserByPhone(token.getUsername());
            return result(u);
        } catch (UnknownAccountException e) {
            return ResponseData.error(400, "Error Phone number.");
        } catch (IncorrectCredentialsException e) {
            return ResponseData.error(400, "Error Password.");
        }

//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        List<User> users = userService.list(queryWrapper);
//        for(User u : users) {
//            if (user.getPhone().equals(u.getPhone()) && user.getPassword().equals(u.getPassword()))
//                return result(u);
//        }
//        return ResponseData.error(400, "Error Phone number or Password.");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData register(@RequestBody User user) throws JsonProcessingException {
        try {
            userService.addUserInfo(user.getPhone(), user.getPassword());
            return result(1);
        } catch (Exception e) {
            return result(0);
        }
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/user/login";
    }
}