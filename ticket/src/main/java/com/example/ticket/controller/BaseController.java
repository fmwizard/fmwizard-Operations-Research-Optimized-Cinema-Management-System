package com.example.ticket.controller;

import com.example.common.response.ResponseData;

public class BaseController {

    //response based on the rows
    public ResponseData result(int rows){
        return rows == 0 ? ResponseData.error() : ResponseData.success();
    }

    //response success based on the object
    public ResponseData result(Object data){
        return ResponseData.success(data);
    }
}
