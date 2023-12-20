package com.traning.blog.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Blog {
    private Long id;

    private String title;

    private String content;

    private String firstPicture;

    private String flag;

    private Integer views;

    private boolean appreciation;

    private boolean shareStatement;

    private boolean commentabled;

    private boolean published;

    private boolean recommend;

    private Date createTime;

    private Date updateTime;

    private Long typeId;
    private Long userId;

    //获取多个标签的id
    private String tagIds;

    private String description;

    private Type type;

    private User user;

    private List<Tag> tags = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();



}
