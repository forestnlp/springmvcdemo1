package com.demo.service;

import com.demo.dto.User;

import java.util.List;

public interface UserService {
    User findUser(String uname, String password);

    List<User> findAllUser();
}
