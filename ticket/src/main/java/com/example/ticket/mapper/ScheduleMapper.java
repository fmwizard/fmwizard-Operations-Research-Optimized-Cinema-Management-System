package com.example.ticket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ticket.entity.Cinema;
import com.example.ticket.entity.Hall;
import com.example.ticket.entity.Movie;
import com.example.ticket.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper extends BaseMapper<Schedule> {
//    public List<Schedule> findScheduleWithInfo();

    public List<Schedule> findScheduleByMovieIdAndCinemaId
            (@Param("cinemaId") long cinemaId, @Param("movieId") long movieId);

    public List<Movie> findMovieInfo();
    public List<Hall> findHallInfo();
}
