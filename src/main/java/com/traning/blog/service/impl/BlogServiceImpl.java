package com.traning.blog.service.impl;

import com.traning.blog.mapper.BlogMapper;
import com.traning.blog.mapper.BlogTagsMapper;
import com.traning.blog.pojo.Blog;
import com.traning.blog.pojo.BlogTags;
import com.traning.blog.pojo.Tag;
import com.traning.blog.service.BlogService;
import com.traning.blog.utils.MarkdownUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogTagsMapper blogTagsMapper;

    @Override
    public List<Blog> getAllBlogs() {
        return blogMapper.selectAllBlogs();
    }

    @Override
    public void saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blogMapper.saveBlog(blog);
        Long id = blog.getId();
        List<Tag> tags = blog.getTags();
        //加入tag和blog关系表中
        for (Tag tag : tags) {
            BlogTags blogTags = new BlogTags();
            blogTags.setBlogId(id);
            blogTags.setTagId(tag.getId());
            blogTagsMapper.save(blogTags);
        }
    }

    @Override
    public void updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        List<Tag> tags = blog.getTags();

        //更新
        blogMapper.updateBlog(blog);

        //更新关系表
        blogTagsMapper.deleteByBlogId(blog.getId());
        for (Tag tag : tags) {
            BlogTags blogTags = new BlogTags();
            blogTags.setBlogId(blog.getId());
            blogTags.setTagId(tag.getId());
            blogTagsMapper.save(blogTags);
        }
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogMapper.selectBlogById(id);
    }

    @Override
    public void deleteBlogById(Long id) {
        blogMapper.deleteBlogById(id);
        blogTagsMapper.deleteByBlogId(id);
    }

    @Override
    public List<Blog> getIndexBlog() {
        return blogMapper.getIndexBlog();
    }

    @Override
    public List<Blog> getRecommendBlog() {
        return blogMapper.getRecommendBlog();
    }

    @Override
    public List<Blog> searchByTitle(String query) {
        return blogMapper.searchByTitle(query);
    }

    @Override
    public Blog getDetailedBlog(Long id) {
        //查询详情
        Blog blog = blogMapper.getDetailedBlog(id);
        if(blog == null){
            throw new NullPointerException("博客不在");
        }

        String content = blog.getContent();
        String contentHTML = MarkdownUtils.markdownToHtmlExtensions(content);
        blog.setContent(contentHTML);

        return blog;
    }

    @Override
    public List<Blog> getBlogByTagId(Long id) {
        return blogMapper.getBlogByTagId(id);
    }


}
