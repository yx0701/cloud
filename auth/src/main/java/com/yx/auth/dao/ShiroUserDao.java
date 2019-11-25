package com.yx.auth.dao;

import com.yx.auth.entity.user.Permission;
import com.yx.auth.entity.user.Role;
import com.yx.auth.entity.user.ShiroUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface ShiroUserDao {

    @Select("select ur.role_id as id, " +
            "r.name as name, " +
            "r.description as description " +
            " from  user_role ur left join role r on ur.role_id = r.id " +
            "where  ur.user_id = #{userId}")
    @Results(
            value = {
                    @Result(id = true,property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "permissionList", column = "id",javaType=List.class,
                            many = @Many(select = "com.yx.auth.dao.ShiroUserDao.findPermissionByRoleId",fetchType = FetchType.DEFAULT))
                    }
            )
    List<Role> findRoleByUserId(int userId);

    @Select("select p.id, p.name, p.url, p.description from role_permission rp " +
            "left join permission p on rp.permission_id = p.id " +
            "where rp.role_id = #{roleId}")
    List<Permission> findPermissionByRoleId(int roleId);

    @Select("select * from user where name = #{userName}")
    ShiroUser getShiroUserByUserName(String userName);

    @Select("select id from user where name = #{userName}")
    Integer getIdByuserName(String userName);
}
