package com.traning.blog.service;

import com.traning.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {
    List<Blog> getAllBlogs();

    void saveBlog(Blog blog);

    void updateBlog(Blog blog);

    Blog getBlogById(Long id);

    void deleteBlogById(Long id);

    List<Blog> getIndexBlog();

    List<Blog> getRecommendBlog();

    List<Blog>  searchByTitle(String query);

    Blog getDetailedBlog(Long id);

    List<Blog> getBlogByTagId(Long id);

    List<Blog> searchByTypeId(Long tid);

    Map<String, List<Blog>> archiveBlog();

    Integer getCountBlog();
}
