package com.example.ticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_movie")
public class Movie {
    @TableId(value="movie_id",type = IdType.AUTO )
    private Long movieId;
    private String movieName;
    private String director;
    private String actor;
    private String publicDate;
    private String duration;
    private String language;
    private String intro;
    private String poster;
    private String genre;
    private String isNew;
    private Double score;
    private Long markCount;
    private String comment;
    private String trailer;

 }
