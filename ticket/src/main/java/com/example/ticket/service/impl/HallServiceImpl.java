package com.example.ticket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ticket.entity.Hall;
import com.example.ticket.mapper.HallMapper;
import com.example.ticket.service.HallService;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl extends ServiceImpl<HallMapper, Hall> implements HallService {
}
