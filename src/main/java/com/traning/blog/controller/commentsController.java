package com.traning.blog.controller;

import com.traning.blog.pojo.Blog;
import com.traning.blog.pojo.Comment;
import com.traning.blog.pojo.User;
import com.traning.blog.service.BlogService;
import com.traning.blog.service.CommentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class commentsController {

    @Resource
    private CommentService commentService;

    @Resource
    private BlogService blogService;

    @GetMapping("{id}")
    public String getComments(@PathVariable("id")Long id,
                              Model model){
        //获取评论
        List<Comment> commentList = commentService.getCommentsByBlogId(id);
        Blog blog = blogService.getDetailedBlog(id);
        model.addAttribute("comments",commentList);
        model.addAttribute("blog",blog);
        return "blog :: commentList";
    }


    @PostMapping()
    public String saveComment(Comment comment, HttpSession session){
        Long id = comment.getBlog().getId();
        comment.setBlog(blogService.getDetailedBlog(id));
        comment.setBlogId(id);
        User user = (User) session.getAttribute("user");

        comment.setAvatar("/images/avatar.jpg");
        comment.setCreateTime(new Date());
        commentService.saveComment(comment);
        return "redirect:/comments/" + id;
    }
}
