package com.example.ticket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ticket.entity.User;

import java.util.List;

public interface UserService extends IService<User>  {
    public User queryUserByPhone(String phone);

    List<User> addUserInfo(String phone, String password);

}