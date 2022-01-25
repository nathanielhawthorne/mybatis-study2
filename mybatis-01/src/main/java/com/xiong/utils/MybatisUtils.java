package com.xiong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory     -->  sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //获取sqlSessionFactory对象
            //加载配置文件
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            /*
            第三步，构造会话工厂获取SqlSessionFactory。
            这个过程其实是用建造者设计模式使用SqlSessionFactoryBuilder对象构建的，
            SqlSessionFactory的最佳作用域是应用作用域。
             */
            // 创建SqLSessionFactory对象实际创建的是Default SqLSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Now that you have a SqlSessionFactory,
    // as the name suggests, you can acquire an instance of SqlSession.
    public static SqlSession getSqlSession(){
        /*
        第四步，创建会话对象SqlSession。由会话工厂创建SqlSession对象，
        对象中包含了执行SQL语句的所有方法，每个线程都应该有它自己的 SqlSession 实例。
        SqlSession的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
         */
        //创建SqLSession对象实际创建的是DefaultSqLSession对象
        return sqlSessionFactory.openSession();
    }
}
