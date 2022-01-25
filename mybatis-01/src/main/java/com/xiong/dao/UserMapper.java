package com.xiong.dao;

import com.xiong.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
    //模糊查询
    List<User> getVagueUserList();
    //map
    int updateUserByMap(Map map);
    //LIMIT实现分页
    List<User> getUserByLimit(Map<String, Integer> map);
}
