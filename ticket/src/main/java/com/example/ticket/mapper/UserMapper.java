package com.example.ticket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    public User queryUserByPhone(String phone);

    List<User> addUserInfo(String phone, String password);
}