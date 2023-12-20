package com.traning.blog.service;

import com.traning.blog.pojo.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();

    List<Tag> selectByIds(String tagIds);

    Tag getTagByName(String name);

    void addTag(Tag tag);

    Tag selectById(Long id);

    void updateTag(Tag tag);

    void deleteTag(Long id);
}
