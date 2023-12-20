package com.traning.blog.mapper;

import com.traning.blog.pojo.BlogTags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogTagsMapper {
    void save(BlogTags blogTags);

    void deleteByBlogId(Long id);

    void deleteByTagId(Long id);
}
