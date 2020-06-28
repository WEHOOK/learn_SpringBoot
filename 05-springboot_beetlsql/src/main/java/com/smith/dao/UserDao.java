package com.smith.dao;


import com.smith.entity.UserEntity;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {

    //自定义根据name查询
    @SqlStatement(params = "name")
    UserEntity selectUserByName(String name);

}
