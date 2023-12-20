package com.traning.blog.service;

import com.traning.blog.pojo.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();

    Type selectById(Long id);

    void deleteById(Long id);

    Type getTypeByName(String name);

    void addType(Type type);

    void updateType(Type type);
}
