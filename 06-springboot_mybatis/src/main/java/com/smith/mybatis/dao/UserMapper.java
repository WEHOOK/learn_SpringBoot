package com.smith.mybatis.dao;

import com.smith.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-06-28
 * @description
 */
@Mapper
public interface UserMapper {
    @Insert("insert into sys_user(name,tel) values(#{name},#{tel})")
    int add(@Param("name") String name,@Param("tel") String tel);

    @Update("update sys_user set name=#{name},tel=#{tel} where id=#{id}")
    int update(@Param("name") String name,@Param("tel") String tel,@Param("id") Integer id);

    @Delete("delete from sys_user where id=#{id}")
    int delete(@Param("id")int id);

    @Select("select * from sys_user where id=#{id}")
    UserEntity findUserById(@Param("id")int id);

    @Select("select * from sys_user")
    List<UserEntity> findUserList();

}
