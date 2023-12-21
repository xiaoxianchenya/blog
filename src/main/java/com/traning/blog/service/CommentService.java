package com.traning.blog.service;

import com.traning.blog.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByBlogId(Long id);

    void saveComment(Comment comment);
}
