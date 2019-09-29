package com.yx.auth.testpackage;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

//@Mapper
@Repository
public interface CityPefDao {


//    @Select("select devid,avg(occupancy_ratio) as avg_occupy,sum(private_calls+group_calls) as call_nums," +
//            "sum(private_callduration+group_callduration) as call_duration from rcu_five_minute_statis" +
//            "where (opdate > #{startTime})and (opdate <=#{endTime})"+
//            "group by devid order by avg_occupy #{sort}"+
//            "limit #{pageSize} offset #{offset}")
@Select("select devid,avg(occupancy_ratio) as avg_occupy,sum(private_calls+group_calls) as call_nums,sum(private_callduration+group_callduration) as call_duration from rcu_five_minute_statis " +
        "where (opdate > #{startTime})and (opdate <=#{endTime})"+
        "group by devid order by avg_occupy asc limit #{pageSize} offset (#{pageNum}-1)*#{pageSize}")
List<RcuCallAndOccupyRatio> sortCallAndOccupy(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime, @Param("sort")String sort, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

}
