package com.traning.blog.service;

import com.traning.blog.pojo.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();

    void saveBlog(Blog blog);

    void updateBlog(Blog blog);

    Blog getBlogById(Long id);

    void deleteBlogById(Long id);
}
