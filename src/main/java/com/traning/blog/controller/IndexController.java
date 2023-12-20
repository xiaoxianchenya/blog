package com.traning.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.traning.blog.pojo.Blog;
import com.traning.blog.pojo.Tag;
import com.traning.blog.pojo.Type;
import com.traning.blog.service.BlogService;
import com.traning.blog.service.TagService;
import com.traning.blog.service.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Resource
    private BlogService blogService;

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    @GetMapping("/")
    public String Index(@RequestParam(required = false,defaultValue = "1",value = "pagenum")Integer pagenum, Model model){

        PageHelper.startPage(pagenum,5);
        //获取全部博客
        List<Blog> IndexBlogList = blogService.getIndexBlog();
        //获取博客类型
        List<Type> allTypes = typeService.getIndexTypes();
        //获取博客标签
        List<Tag> allTags = tagService.getIndexTags();
        //获取推荐博客
        List<Blog> recommendBolgList = blogService.getRecommendBlog();


        //封装
        PageInfo pageInfo = new PageInfo(IndexBlogList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",allTypes);
        model.addAttribute("tags",allTags);
        model.addAttribute("recommendBlogs",recommendBolgList);

        return "index";
    }

}
