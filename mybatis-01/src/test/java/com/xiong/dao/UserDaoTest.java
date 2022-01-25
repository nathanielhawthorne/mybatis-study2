package com.xiong.dao;

import com.xiong.pojo.User;
import com.xiong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(7,"猎豹","123333"));
        if (res>0){
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"呵呵","123123"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getVagueUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getVagueUserList();
        for (User user:userList) {
            System.out.println(user);

        }
        sqlSession.close();
    }
    @Test
    public void updateUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("info:进入了testLog4j");
        //logger.debug("debug:进入了testLog4j");
        //logger.error("error:进入了testLog4j");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id","2");
        map.put("name","lin");
        map.put("pwd","12341234");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUserByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getUserByLimit(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",3);
        // 执行查询语句
        List<User> userList = mapper.getUserByLimit(map);
        for (User user:userList
             ) {
            System.out.println(user);
            
        }
        sqlSession.close();
    }
}
