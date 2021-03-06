package com.xiong.dao;

import com.xiong.pojo.User;
import org.apache.ibatis.annotations.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User 蜥蜴);

    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

}
