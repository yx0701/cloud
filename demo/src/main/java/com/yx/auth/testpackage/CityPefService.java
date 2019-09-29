package com.yx.auth.testpackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CityPefService {
    @Autowired
    private CityPefDao cityPefDao;


    //根据
     List<RcuCallAndOccupyRatio> sortByOccupy(Timestamp startTime,Timestamp endTime, String sort, int pageNum, int pageSize){
        return cityPefDao.sortCallAndOccupy(startTime,endTime,sort,pageNum,pageSize);
    }


}
