package com.example.ticket.controller.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.response.ResponseData;
import com.example.ticket.controller.BaseController;
import com.example.ticket.entity.Hall;
import com.example.ticket.entity.Movie;
import com.example.ticket.entity.Schedule;
import com.example.ticket.entity.Seat;
import com.example.ticket.mapper.ScheduleMapper;
import com.example.ticket.service.MovieService;
import com.example.ticket.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ScheduleController extends BaseController {

    @Autowired
    ScheduleService scheduleService;

//    @Autowired
//    com.example.ticket.service.MovieService movieService;
//
//    @Autowired
//    com.example.ticket.service.HallService hallService;

    @GetMapping("/schedule")
    public ResponseData findScheduleWithInfo(){
        List<Schedule> schedules = scheduleService.list();
        List<Movie> movies = scheduleService.findMovieInfo();
        List<Hall> halls = scheduleService.findHallInfo();
        ArrayList<ArrayList> info = new ArrayList<ArrayList>();
        for(Schedule schedule: schedules) {
            ArrayList item = new ArrayList<>();
            item.add(schedule);
            for (Hall hall : halls) {
                if (schedule.getHallId().equals(hall.getHallId())) {
                    item.add(hall);
                    break;
//                } else {
//                System.out.print(schedule.getHallId());
//                System.out.print("======>");
//                System.out.println(hall.getHallId());
                }
            }
            for (Movie movie : movies) {
                if (schedule.getMovieId().equals(movie.getMovieId())) {
                    item.add(movie);
                    break;
                }
            }
            info.add(item);
        }
        return result(info);
    }

    @GetMapping("/schedule/{movieId}")
    public ResponseData findMovieById(@PathVariable Long movieId){
        List<Schedule> schedules = scheduleService.list();
        List<Hall> halls = scheduleService.findHallInfo();
        ArrayList<ArrayList> movieInfo = new ArrayList<ArrayList>();
        for(Schedule schedule: schedules) {
            ArrayList item = new ArrayList<>();
            if (schedule.getMovieId().equals(movieId)) {
                item.add(schedule);
                for (Hall hall : halls) {
                    if (schedule.getHallId().equals(hall.getHallId())) {
                        item.add(hall);
                        break;
                    }
                }
            }
            movieInfo.add(item);
        }
        return result(movieInfo);
    }


    @PostMapping("/schedule")
    public ResponseData add(@RequestBody Schedule schedule){
        return result(scheduleService.save(schedule));
    }

    @PutMapping("/schedule")
    public ResponseData update(@RequestBody Schedule schedule){
        return result(scheduleService.updateById(schedule));
    }

    @DeleteMapping("/schedule/{ids}")
    public ResponseData delete(@PathVariable Long[] ids){
        return result(scheduleService.removeByIds(Arrays.asList(ids)));
    }


}
