package com.example.ticket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ticket.entity.Cinema;
import com.example.ticket.entity.Hall;
import com.example.ticket.entity.Movie;
import com.example.ticket.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleService extends IService<Schedule> {
    List<Schedule> findScheduleByMovieIdAndCinemaId(long movieId, long cinemaId);

//    List<Schedule> findScheduleWithInfo();

    List<Movie> findMovieInfo();
    List<Hall> findHallInfo();

}
