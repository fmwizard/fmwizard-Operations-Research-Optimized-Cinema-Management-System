package com.example.common.response;

import org.springframework.http.HttpStatus;
import com.example.common.constant.HttpCode;

import java.util.HashMap;

/**
 * Store the json response in map
 */

public class ResponseData extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    //operation result
    private static final String Message = "msg";

    //http code
    private static final String Code = "code";


    //response data
    private static final String Data = "data";

    //empty response
    public ResponseData(){
    }

    //response with no data
    public ResponseData(int code, String msg){
        super.put(Code, code);
        super.put(Message, msg);
    }

    //construct a response
    public ResponseData(int code, String msg, Object data){
        super.put(Code, code);
        super.put(Message, msg);
        if(data != null){
            super.put(Data, data);
        }
    }

    //successful response
    public static ResponseData success(){
        return success("Successful operation!");
    }

    public static ResponseData success(String msg){
        return success(msg, null);
    }

    public static ResponseData success(Object data){
        return success("Successful operation!", data);
    }

    public static ResponseData success(String msg, Object data){
        return new ResponseData(HttpCode.SUCCESS, msg, data);
    }

    //fail response
    public static ResponseData error(){
        return error("Fail operation!");
    }

    public static ResponseData error(String msg){
        return error(msg, null);
    }

    public static ResponseData error(int code, String msg){
        return new ResponseData(code, msg, null);
    }

    public static ResponseData error(String msg, Object data){
        return new ResponseData(HttpCode.ERROR, msg, data);
    }
}
