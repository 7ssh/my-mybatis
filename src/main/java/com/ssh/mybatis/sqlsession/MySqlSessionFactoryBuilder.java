package com.ssh.mybatis.sqlsession;

import com.ssh.mybatis.cfg.MyConfiguration;
import com.ssh.mybatis.sqlsession.impl.MySqlSessionFactoryImpl;
import com.ssh.mybatis.util.MyXMLConfigBuilder;

import java.io.InputStream;

/**
 * 创建一个SqlSessionFactory对象
 */
public class MySqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建MySqlSessionFactory
     * @param config
     * @return
     */
    public MySqlSessionFactory build(InputStream config){
        MyConfiguration myConfiguration = MyXMLConfigBuilder.loadConfiguration(config);
        return new MySqlSessionFactoryImpl(myConfiguration);
    }
}
