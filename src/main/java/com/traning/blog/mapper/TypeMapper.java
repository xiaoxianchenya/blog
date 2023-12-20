package com.traning.blog.mapper;

import com.traning.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface TypeMapper {
    List<Type> selectAllType();

    Type selectById(Long id);

    void deleteById(Long id);

    Type getTypeByName(String name);

    void addType(Type type);

    void updateType(Type type);
}
