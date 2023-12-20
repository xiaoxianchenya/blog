package com.traning.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.traning.blog.pojo.Blog;
import com.traning.blog.pojo.Type;
import com.traning.blog.service.BlogService;
import com.traning.blog.service.TypeService;
import com.traning.blog.service.impl.TypeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.function.LongFunction;

@Slf4j
@Controller
@RequestMapping("types")
public class TypesController {

    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;



    @GetMapping("/{id}")
    public String typeViews(@RequestParam(required = false, defaultValue = "1", value = "pageNum")Integer pageNum,
                            @PathVariable("id") Long id,
                            Model model){

        List<Type> types = typeService.getIndexTypes();
        if(id == -1){
            id = types.get(0).getId();
        }
        PageHelper.startPage(pageNum, 5);
        List<Blog> blogs = blogService.searchByTypeId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("types", types);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeType", id);

        return "/types";
    }

}
