package com.ssh.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * mybatis.XML对应的类
 */
public class MyConfiguration {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String,MyMapper> mappers = new HashMap<String,MyMapper>();

    public Map<String, MyMapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, MyMapper> mappers) {
        this.mappers.putAll(mappers);//此处需要使用追加的方式,因为配置文件的mapper可能有多个
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
