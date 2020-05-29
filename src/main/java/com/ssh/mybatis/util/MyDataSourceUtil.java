package com.ssh.mybatis.util;

import com.ssh.mybatis.cfg.MyConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于创建数据源的工具类
 */
public class MyDataSourceUtil {

    /**
     * 获取连接
     * @param myConfiguration
     * @return
     */
    public static Connection getConnection(MyConfiguration myConfiguration){
        try {
            Class.forName(myConfiguration.getDriver());
            return DriverManager.getConnection(myConfiguration.getUrl(), myConfiguration.getUsername(), myConfiguration.getPassword());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
