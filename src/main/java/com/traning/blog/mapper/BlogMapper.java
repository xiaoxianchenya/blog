package com.traning.blog.mapper;

import com.traning.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    List<Blog> selectAllBlogs();

    void saveBlog(Blog blog);

    Blog selectBlogById(Long id);

    void updateBlog(Blog blog);

    void deleteBlogById(Long id);

    List<Blog> selectByTypeId(Long id);

    List<Blog> getIndexBlog();

    List<Blog> getRecommendBlog();

    List<Blog> searchByTitle(String query);

    Blog getDetailedBlog(Long id);

    List<Blog> getBlogByTagId(Long id);
}
