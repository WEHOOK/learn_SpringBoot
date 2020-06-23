package com.smith.springboot_jdbc.dao.impl;

import com.smith.springboot_jdbc.dao.UserDao;
import com.smith.springboot_jdbc.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(UserEntity user) {
        return jdbcTemplate.update("insert into sys_user(name,tel)values(?,?)",user.getName(),user.getTel());
    }

    @Override
    public int update(UserEntity user) {
        return  jdbcTemplate.update(" update sys_user set name = ?,tel = ? where id = ?",user.getName(),user.getTel(),user.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from table sys_user where id=?",id);
    }

    @Override
    public UserEntity findUserById(int id) {
        List<UserEntity> userList = jdbcTemplate.query("select * from sys_user where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(UserEntity.class));
        if(!userList.isEmpty()){
            return  userList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<UserEntity> findUserList() {
        String sql = "select * from sys_user";
        List userList = jdbcTemplate.queryForList(sql,new Object[]{});

//        List<UserEntity> userList = jdbcTemplate.query("select * from sys_user",new Object[]{},
//                new BeanPropertyRowMapper<>(UserEntity.class));

        if(!userList.isEmpty()){
            return userList;
        }else {
            return null;
        }

    }
}
