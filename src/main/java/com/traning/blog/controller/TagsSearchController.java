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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("tags")
public class TagsSearchController {


    @Resource
    private TagService tagService;

    @Resource
    private BlogService blogService;

    @GetMapping("/{id}")
    public String showTypes(@PathVariable("id") Long id,
                            @RequestParam(required = false, defaultValue = "1", value = "pageNum") Integer pageNum,
                            Model model) {
        List<Tag> tags = tagService.getIndexTags();
        if (id.equals(Long.valueOf(-1))) {
            id = tags.get(0).getId();
        }
        PageHelper.startPage(pageNum, 5);
        List<Blog> blogs = blogService.getBlogByTagId(id);
        PageInfo pageInfo = new PageInfo(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", tags);
        model.addAttribute("activeTagId", id);
        return "tags";
    }

}
