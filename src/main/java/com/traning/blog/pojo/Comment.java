package com.traning.blog.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;

    //头像
    private String avatar;
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;  //父评论id
    private String parentNickname;

    //回复评论
    //private List<Comment> replyComments = new ArrayList<>();

    //父评论
    private Comment parentComment;
    private Blog blog;

    private boolean adminComment;  //是否为管理员评论
}
