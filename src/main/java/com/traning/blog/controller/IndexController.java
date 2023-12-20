package com.traning.blog.controller;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Resource


    @GetMapping("/")
    public String Index(@RequestParam(required = false,defaultValue = "1",value = "pagenum")Integer pagenum, Model model){

        PageHelper.startPage(pagenum,5);
        //获取全部博客
        //获取博客类型
        //获取博客标签
        //获取推荐博客

        //封装
        return "";
    }

}
