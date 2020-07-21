package com.smith.shiro.dao;

import com.smith.shiro.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
@Mapper
public interface UserInfoDao {

    @Select("select * from user_login where username=#{username}")
    UserInfo queryByName(String username);
}
