package com.yx.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Table;

//@Table(name = "user")
@Data
@ApiModel("用户信息")
public class User {
    @Column(name = "name")
    @ApiModelProperty("姓名")
    private String myname;
    @Column(name = "password")
    private String password;

    public User name(String name){
        this.setMyname(name);
        return this;
    }

    public User password(String password){
        this.setPassword(password);
        return this;
    }

    public User build(){
        return this;
    }

}
