package com.yx.auth.testpackage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RcuCallAndOccupyRatio {
    private String devId;     //域名
    @JsonProperty("anotherName")
    private String devName;   //基站名字
    private float avgOccupy; //占忙比
    private int callNums;     //呼叫量
    private int callDuration; //呼叫时长

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public float getAvgOccupy() {
        return avgOccupy;
    }

    public void setAvgOccupy(float avgOccupy) {
        this.avgOccupy = avgOccupy;
    }

    public int getCallNums() {
        return callNums;
    }

    public void setCallNums(int callNums) {
        this.callNums = callNums;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }
}
