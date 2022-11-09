package com.example.ticket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ticket.entity.Seat;

import java.util.List;

public interface SeatMapper extends BaseMapper<Seat> {
    public List<Seat> findSeatByHallId(long hallId);
}
