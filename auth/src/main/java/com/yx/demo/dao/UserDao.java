package com.yx.dao;

import com.yx.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select name, password from user where name =#{name} and password =#{password}")
    User login(User user);

    @Select("select count(*) from user where name =#{userName}")
    int validateReg(String userName);

    @Insert("insert into user(name,password) values(#{name},#{password})")
    boolean reg(User user);
}
