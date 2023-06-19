package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    // 调用Dao层，注入UserMapper对象
    @Autowired
    private UserMapper userMapper;
    // 通过User的用户账号和用户密码查询用户信息
    public User login(User user) {
        return userMapper.login(user);
    }

}
