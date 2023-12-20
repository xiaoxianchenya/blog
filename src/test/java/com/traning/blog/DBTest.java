package com.traning.blog;

import com.traning.blog.mapper.BlogMapper;
import com.traning.blog.pojo.Blog;
import com.traning.blog.service.BlogService;
import com.traning.blog.service.impl.BlogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DBTest {
    @Autowired
    private  BlogService blogService;
    @Test
    public void test(){
        List<Blog> blogs = blogService.searchByTitle("maven");
        for (Blog blog : blogs) {
            log.error(blog.toString());
        }
    }

    @Test
    public void test_searchByTypeId(){
        List<Blog> blogs = blogService.searchByTypeId(3L);
        for (Blog blog : blogs) {
            log.error(blog.toString());
        }
    }

}
