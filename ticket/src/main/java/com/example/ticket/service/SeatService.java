package com.example.ticket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ticket.entity.Seat;

import java.util.List;

public interface SeatService extends IService<Seat> {
    List<Seat> findSeatByHallId(long hallId);
}
