package com.traning.blog.service.impl;

import com.traning.blog.mapper.CommentMapper;
import com.traning.blog.pojo.Comment;
import com.traning.blog.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentsByBlogId(Long id) {
        return commentMapper.getCommentsByBlogId(id);
    }

    @Override
    public void saveComment(Comment comment) {
         commentMapper.saveComment(comment);
    }
}
