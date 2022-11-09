package com.example.ticket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ticket.entity.Cinema;
import com.example.ticket.entity.Hall;
import com.example.ticket.entity.Movie;
import com.example.ticket.entity.Schedule;
import com.example.ticket.mapper.MovieMapper;
import com.example.ticket.mapper.ScheduleMapper;
import com.example.ticket.service.ScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>  implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

//    @Override
//    public List<Schedule> findScheduleWithInfo() {
//        return scheduleMapper.findScheduleWithInfo();
//    }

    @Override
    public List<Schedule> findScheduleByMovieIdAndCinemaId(long movieId, long cinemaId){
        return scheduleMapper.findScheduleByMovieIdAndCinemaId(movieId, cinemaId);
    }
    @Override
    public List<Movie> findMovieInfo() {
        return scheduleMapper.findMovieInfo();
    };
    @Override
    public List<Hall> findHallInfo() {
        return scheduleMapper.findHallInfo();
    };
}
