package com.example.ticket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ticket.entity.Schedule;
import com.example.ticket.entity.Seat;
import com.example.ticket.mapper.ScheduleMapper;
import com.example.ticket.mapper.SeatMapper;
import com.example.ticket.service.ScheduleService;
import com.example.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat> implements SeatService {
    @Autowired
    private SeatMapper seatMapper;

    @Override
    public List<Seat> findSeatByHallId(long hallId){
        return seatMapper.findSeatByHallId(hallId);
    }
}
