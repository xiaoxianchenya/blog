package com.traning.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class User {

    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private List<Blog> blogs = new ArrayList<>();

}
