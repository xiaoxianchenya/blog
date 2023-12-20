package com.traning.blog.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Type {

    private Long id;
    private String name;


    List<Blog> blogs = new ArrayList<>();
}
