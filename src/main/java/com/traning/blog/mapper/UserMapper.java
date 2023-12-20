package com.traning.blog.mapper;

import com.traning.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectUserByUserName(@Param("username") String username,@Param("md5Password") String md5Password);
}


