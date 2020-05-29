package com.ssh.mybatis.sqlsession;

public interface MySqlSession {

    <T> T getMapper(Class<T> mapperInterface);

    void close();
}
