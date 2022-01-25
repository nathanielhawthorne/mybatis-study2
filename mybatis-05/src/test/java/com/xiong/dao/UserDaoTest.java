package com.xiong.dao;

import com.xiong.pojo.User;
import com.xiong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(String.valueOf(UserDaoTest.class));
    @Test
    public void test(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(1);
        sqlSession.close();
    }

     /*
        List<User> userList = mapper.getUsers();

        for (User user : userList) {
            System.out.println(user);
        }

        User userById = mapper.getUserById(1);
        System.out.println(userById);
        mapper.addUser(new User(8,"蜥蜴","123123"));
        mapper.updateUser(new User(1,"毒蛇","098765"));
         */

}
