package com.traning.blog.service.impl;

import com.traning.blog.mapper.UserMapper;
import com.traning.blog.pojo.User;
import com.traning.blog.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        //处理密码
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        return userMapper.selectUserByUserName(username,md5Password);
    }
}
