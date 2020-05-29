package com.ssh.mybatis.sqlsession.impl;

import com.ssh.mybatis.cfg.MyConfiguration;
import com.ssh.mybatis.sqlsession.MySqlSession;
import com.ssh.mybatis.sqlsession.MySqlSessionFactory;

/**
 * MySqlSessionFactory的实现类
 */
public class MySqlSessionFactoryImpl implements MySqlSessionFactory {

    private MyConfiguration myConfiguration;

    public MySqlSessionFactoryImpl(MyConfiguration myConfiguration) {
        this.myConfiguration = myConfiguration;
    }

    /**
     * 用于创建一个新的数据库操作对象
     * @return
     */
    @Override
    public MySqlSession openSession() {
        return new MySqlSessionImpl(myConfiguration);
    }
}
