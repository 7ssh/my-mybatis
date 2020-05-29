package com.ssh.mybatis.sqlsession.impl;

import com.ssh.mybatis.cfg.MyConfiguration;
import com.ssh.mybatis.proxy.MyMapperProxy;
import com.ssh.mybatis.sqlsession.MySqlSession;
import com.ssh.mybatis.util.MyDataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlSessionImpl implements MySqlSession {

    private MyConfiguration myConfiguration;
    private Connection connection;

    public MySqlSessionImpl(MyConfiguration myConfiguration) {
        this.myConfiguration = myConfiguration;
        //创建对象时就给connection赋值
        connection = MyDataSourceUtil.getConnection(myConfiguration);
    }

    /**
     * 用于创建代理对象
     * @param mapperInterface  mapper接口的字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> mapperInterface) {
        /**
         * 参数说明
         * 1.代理谁就用谁的类加载器
         * 2.代理谁就用谁的接口
         * 3.如何代理
         */
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[]{mapperInterface}, new MyMapperProxy(myConfiguration.getMappers(), connection));
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        if (connection == null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
