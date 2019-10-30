package com.yx.demo.entity;

import java.io.Serializable;

public class JsonData implements Serializable {

    private int code;
    private String msg;

    public static final int SUCCESS_CODE = 1;
    public static final int ERROR_CODE = -1;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonData buildSuccess(String msg){
        return new JsonData(1,msg);
    }

    public static JsonData buildError(){
        return new JsonData(-1,"ERROR");
    }
}
