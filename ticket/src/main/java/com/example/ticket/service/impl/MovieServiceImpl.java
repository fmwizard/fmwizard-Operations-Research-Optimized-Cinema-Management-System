package com.example.ticket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ticket.entity.Movie;
import com.example.ticket.mapper.MovieMapper;
import com.example.ticket.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Override
    public ArrayList<String> getActorName(String actor){
        ArrayList<String> name = new ArrayList<>();
        String[] a = actor.split(".jpg ");
        for (String s : a) {
            int endIndex = s.indexOf("-");
            String str = s.substring(0, endIndex);
            name.add(str);
        }
        return name;
    }
}
