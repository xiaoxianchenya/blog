package com.traning.blog.service;


import com.traning.blog.pojo.User;

public interface UserService {
    User login(String username, String password);
}
