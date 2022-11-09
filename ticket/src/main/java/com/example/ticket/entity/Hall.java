package com.example.ticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_hall")
public class Hall {
    @TableId(value="hall_id",type = IdType.AUTO )
    private Long hallId;

    private Integer cinemaId;
    private String hallName;
    private Integer hallRow;
    private Integer hallCol;
}
