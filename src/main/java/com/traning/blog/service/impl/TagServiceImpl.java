package com.traning.blog.service.impl;

import com.traning.blog.mapper.BlogTagsMapper;
import com.traning.blog.mapper.TagMapper;
import com.traning.blog.pojo.Tag;
import com.traning.blog.service.TagService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Resource
    private BlogTagsMapper blogTagsMapper;

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.selectAllTags();
    }

    @Override
    public List<Tag> selectByIds(String tagIds) {

        ArrayList<Tag> tags = new ArrayList<>();
        //tagIds字符串转换为tag列表
        List<Long> tagIdList = TagsToList(tagIds);
        for(Long id : tagIdList){
            tags.add(tagMapper.selectById(id));
        }
        return tags;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public void addTag(Tag tag) {
        tagMapper.addTag(tag);
    }

    @Override
    public Tag selectById(Long id) {

        return tagMapper.selectById(id);
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }

    @Override
    public void deleteTag(Long id) {
        //删除tag
        tagMapper.deleteTagById(id);
        //删除关系表
        blogTagsMapper.deleteByTagId(id);

    }

    private List<Long> TagsToList(String tagIds) {
        List<Long> tagIdList = new ArrayList<>();
        if(StringUtils.hasText(tagIds)){
            tagIdList = Arrays.asList(tagIds.split(","))
                    .stream()
                    .map(s -> Long.parseLong(s.trim()))
                    .collect(Collectors.toList());
        }
        return tagIdList;
    }
}
