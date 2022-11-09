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
@TableName("t_seat")
public class Seat
{
    @TableId(value="seat_id",type = IdType.AUTO )
    private Integer seatId;

    private Integer hallId;
    private Integer row;
    private Integer column;
    // 0-available 1-chosen 2-sold
    private Integer isAvailble;
}
