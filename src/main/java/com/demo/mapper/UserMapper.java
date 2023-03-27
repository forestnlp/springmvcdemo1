package com.demo.mapper;

import com.demo.dto.User;

import java.util.List;

public interface UserMapper {
    User findUser(String uname, String password);
    List<User> findAllUser();
}
