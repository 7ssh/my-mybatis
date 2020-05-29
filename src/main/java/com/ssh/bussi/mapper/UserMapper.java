package com.ssh.bussi.mapper;

import com.ssh.bussi.pojo.User;
import com.ssh.mybatis.annotation.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> selectList();
}
