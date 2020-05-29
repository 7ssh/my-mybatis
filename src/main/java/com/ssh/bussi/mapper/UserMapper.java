package com.ssh.bussi.mapper;

import com.ssh.bussi.pojo.User;
import com.ssh.mybatis.annotation.MySelect;

import java.util.List;

public interface UserMapper {

    @MySelect("select * from user")
    List<User> selectList();
}
