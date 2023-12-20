package com.traning.blog.mapper;

import com.traning.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    List<Tag> selectAllTags();

    Tag selectById(Long id);

    Tag getTagByName(String name);

    void addTag(Tag tag);

    void updateTag(Tag tag);

    void deleteTagById(Long id);
}
