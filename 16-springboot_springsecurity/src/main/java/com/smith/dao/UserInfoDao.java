package com.smith.dao;

import com.smith.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
@Mapper
@Repository
public interface UserInfoDao {

    @Select("select * from user_login where username=#{username}")
    UserInfo queryByName(String username);
}
