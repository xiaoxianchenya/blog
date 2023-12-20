package com.traning.blog.controller;

import com.traning.blog.pojo.Blog;
import com.traning.blog.service.BlogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("archives")
public class archivesController {

    @Resource
    private BlogService blogService;



    @GetMapping()
    public String getArchives(Model model){
        //获取时间线的博客
        Map<String, List<Blog>> archivesMap = blogService.archiveBlog();
        //获取博客数量
        Integer count = blogService.getCountBlog();

        model.addAttribute("archiveMap",archivesMap);
        model.addAttribute("blogCount",count);

        return "archives";
    }


}
