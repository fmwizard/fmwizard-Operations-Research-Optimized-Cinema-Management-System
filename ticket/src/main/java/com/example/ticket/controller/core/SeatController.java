package com.example.ticket.controller.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.response.ResponseData;
import com.example.ticket.controller.BaseController;
import com.example.ticket.entity.Hall;
import com.example.ticket.entity.Movie;
import com.example.ticket.entity.Seat;
import com.example.ticket.service.HallService;
import com.example.ticket.service.MovieService;
import com.example.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seat")
public class SeatController extends BaseController {
    @Autowired
    SeatService seatService;

    @Autowired
    HallService hallService;

    @GetMapping("/{hallId}")
    public ResponseData findSeatList(@PathVariable Long hallId){
        Hall hall = hallService.getById(hallId);
        List<Seat> seat = seatService.findSeatByHallId(hallId);
        ModelMap map = new ModelMap();
        map.addAttribute("hall",hall);
        map.addAttribute("seat",seat);
        return result(map);
    }
}
