package com.demo.service.impl;

import com.demo.dto.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(String uname, String password) {
        return userMapper.findUser(uname,password);
    }
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
