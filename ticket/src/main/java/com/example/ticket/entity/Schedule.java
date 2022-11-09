package com.example.ticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_schedule")
public class Schedule {
    @TableId(value="schedule_id",type = IdType.AUTO )
    private Integer scheduleId;

//    @JoinColumn(name = "movieId")//外键
//    private Movie movie;
//    @JoinColumn(name = "cinemaId")//外键
//    private Cinema cinema;
//    @JoinColumn(name = "hallId")//外键
//    private Hall hall;
    private Long movieId;
    private Long cinemaId;
    private Long hallId;

    private String showDate;

    private Double price;
}
