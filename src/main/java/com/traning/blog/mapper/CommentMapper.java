package com.traning.blog.mapper;

import com.traning.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getCommentsByBlogId(Long id);

    void saveComment(Comment comment);
}
