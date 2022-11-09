package com.example.ticket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ticket.entity.Movie;

import java.util.ArrayList;

public interface MovieService extends IService<Movie> {
    ArrayList<String> getActorName(String actor);
}
