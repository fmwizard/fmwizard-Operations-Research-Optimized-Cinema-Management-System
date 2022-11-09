package com.example.ticket;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ticket.entity.Hall;
import com.example.ticket.entity.Movie;
import com.example.ticket.entity.Seat;
import com.example.ticket.mapper.HallMapper;
import com.example.ticket.mapper.MovieMapper;
import com.example.ticket.mapper.ScheduleMapper;
import com.example.ticket.mapper.SeatMapper;
import com.example.ticket.service.MovieService;
import com.example.ticket.controller.core.MovieController;
import com.example.ticket.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest

class TicketApplicationTests {

    @Autowired
    private MovieService movieService;
    private MovieController movieController;
    @Test
    void contextLoads() {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<Movie>();
        queryWrapper.like("is_new", "TRUE");
        List<Movie> movies = movieService.list(queryWrapper);
        movies = movieController.getActor(movies);
        System.out.println(movies);
    }

}
