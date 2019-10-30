package com.yx.demo.dao;

import com.yx.demo.entity.user.ShiroUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CacheDao {

    @Select("select * from user where name = #{userName}")
    ShiroUser getUser(String userName);

    @Select("select count(*) from user")
    Integer getUserCount();


}
