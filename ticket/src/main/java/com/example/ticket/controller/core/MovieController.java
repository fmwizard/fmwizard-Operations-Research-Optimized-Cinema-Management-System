package com.example.ticket.controller.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.response.ResponseData;
import com.example.ticket.controller.BaseController;
import com.example.ticket.entity.Movie;
import com.example.ticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {

    @Autowired
    MovieService movieService;


    @GetMapping("/hot")
    public ResponseData getHottest(){
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<Movie>();
        queryWrapper.like("is_new", "FALSE");
        queryWrapper.orderByDesc("public_date");
        List<Movie> movies = movieService.list(queryWrapper);
        movies = getActor(movies);
        return result(movies);
    }


    @GetMapping("/new")
    public ResponseData getNewest(){
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<Movie>();
        queryWrapper.like("is_new", "TRUE");
        queryWrapper.orderByAsc("public_date");
        List<Movie> movies = movieService.list(queryWrapper);
        movies = getActor(movies);
        return result(movies);
    }


    @GetMapping("/seen")
    public ResponseData getSeen(){
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<Movie>();
        queryWrapper.like("is_new", "FALSE");
        queryWrapper.orderByDesc("public_date");
        List<Movie> movies = movieService.list(queryWrapper);
        ArrayList<Movie> removed = new ArrayList<>();
        for(Movie movie:movies){
            double i = Math.random();
            if(i<0.5)
                removed.add(movie);
        }
        movies.removeAll(removed);
        movies = getActor(movies);
        return result(movies);
    }

    @GetMapping("/want")
    public ResponseData getWantest(){
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<Movie>();
        queryWrapper.like("is_new", "TRUE");
        queryWrapper.orderByDesc("public_date");
        List<Movie> movies = movieService.list(queryWrapper);
        ArrayList<Movie> removed = new ArrayList<>();
        for(Movie movie:movies){
            double i = Math.random();
            if(i<=0.5)
                removed.add(movie);
        }
        movies.removeAll(removed);
        movies = getActor(movies);
        return result(movies);
    }

    @GetMapping("/{movieId}")
    public ResponseData getById(@PathVariable Long movieId){
        ArrayList<Movie> movie = new ArrayList<>();
        movie.add(movieService.getById(movieId));
        return result(getActor(movie));
    }
    //extract actors' name
    public List<Movie> getActor(List<Movie> movies){
        ArrayList<String> actorName = new ArrayList<>();
        for(Movie m : movies){
            actorName.addAll(movieService.getActorName(m.getActor()));
            String s = actorName.toString();
            m.setActor(s.substring(1, s.length()-1));
            actorName.clear();
        }
        return movies;
    }
}
