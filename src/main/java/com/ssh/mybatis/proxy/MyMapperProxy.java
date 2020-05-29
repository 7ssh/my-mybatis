package com.ssh.mybatis.proxy;

import com.ssh.mybatis.cfg.MyMapper;
import com.ssh.mybatis.util.MyExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MyMapperProxy implements InvocationHandler {

    /**
     * 这个mapperMap装的是mapper.xml中所有的mapper
     * MyMapper中装的是sql和实体类的全限定类名
     * map的key是全限定类名+方法名
     */
    private Map<String, MyMapper> mapperMap;

    //连接对象
    private Connection conn;

    public MyMapperProxy(Map<String, MyMapper> mapperMap, Connection conn) {
        this.mapperMap = mapperMap;
        this.conn = conn;

    }

    /**
     * 这个方法的作用就是对方法进行增强的，我们的增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在的类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methodName;
        //4.获取mapperMap的myMapper对象
        MyMapper myMapper = mapperMap.get(key);
        //5.判断是否有mapper
        if (myMapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.调用工具类查询
        return new MyExecutor().selectList(myMapper,conn);
    }
}
