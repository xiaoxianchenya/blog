package com.traning.blog.service.impl;

import com.traning.blog.mapper.BlogMapper;
import com.traning.blog.mapper.BlogTagsMapper;
import com.traning.blog.mapper.TypeMapper;
import com.traning.blog.pojo.Blog;
import com.traning.blog.pojo.Type;
import com.traning.blog.service.BlogService;
import com.traning.blog.service.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogTagsMapper blogTagsMapper;

    @Override
    public List<Type> getAllTypes() {
        return typeMapper.selectAllType();
    }

    @Override
    public Type selectById(Long id) {
        return typeMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        typeMapper.deleteById(id);
        //删除所有带有标签的博客
        List<Blog> blogList = blogMapper.selectByTypeId(id);
        for(Blog blog : blogList){
            blogTagsMapper.deleteByBlogId(blog.getId());
            blogMapper.deleteBlogById(blog.getId());
        }

    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public void addType(Type type) {
        typeMapper.addType(type);
    }

    @Override
    public void updateType(Type type) {
        typeMapper.updateType(type);
    }
}
