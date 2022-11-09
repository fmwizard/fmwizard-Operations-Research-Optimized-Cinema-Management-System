package com.example.ticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_user")
public class User {
    @TableId(value="user_id",type = IdType.AUTO )
    private Long userId;

    private String userName;
    private String avatar;
    private String password;
    private String phone;
    private String sex;
    private String birthday;
    private Double sign;
}