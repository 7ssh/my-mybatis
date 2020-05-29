package com.ssh.bussi.test;

import com.ssh.bussi.mapper.UserMapper;
import com.ssh.bussi.pojo.User;
import com.ssh.mybatis.io.MyResources;
import com.ssh.mybatis.sqlsession.MySqlSession;
import com.ssh.mybatis.sqlsession.MySqlSessionFactory;
import com.ssh.mybatis.sqlsession.MySqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //1.读取配置文件
        InputStream in = MyResources.getResourceAsStream("mybatis.xml");
        //2.创建SqlSessionFactoryBuilder对象
        MySqlSessionFactoryBuilder builder = new MySqlSessionFactoryBuilder();
        //3.创建SqlSessionFactory对象
        MySqlSessionFactory factory = builder.build(in);
        //4.创建SqlSession对象
        MySqlSession session = factory.openSession();
        //5.得到UserMapper的代理类对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //6.执行方法
        List<User> users = userMapper.selectList();
        System.out.println("users = " + users);
    }
}
