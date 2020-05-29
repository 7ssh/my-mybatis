package com.ssh.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class MyResources {

    public static InputStream getResourceAsStream(String filePath){
        return MyResources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
