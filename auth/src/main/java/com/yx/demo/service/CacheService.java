package com.yx.service;

import com.yx.dao.CacheDao;
import com.yx.entity.user.ShiroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService implements CacheDao {

    @Autowired
    private CacheDao cacheDao;

    @Override
    @Cacheable(value = "getUser", key ="targetClass + methodName + #p0")
    public ShiroUser getUser(String userName) {
        System.out.println("getUser 从数据库获取");
        return cacheDao.getUser(userName);
    }

    @Override
    public Integer getUserCount() {
        return cacheDao.getUserCount();
    }
}
