package com.traning.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.traning.blog.pojo.Blog;
import com.traning.blog.pojo.Tag;
import com.traning.blog.pojo.Type;
import com.traning.blog.pojo.User;
import com.traning.blog.service.BlogService;
import com.traning.blog.service.TagService;
import com.traning.blog.service.TypeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.slf4j.MDC;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.annotation.Retention;
import java.util.List;

@Controller
@RequestMapping("admin/blogs")
public class BlogController {

    @Resource
    private BlogService blogService;

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    /**
     * 分页查询全部博客
     *
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping()
    public String getBlogs(@RequestParam(required = false, defaultValue = "1", value = "pagenum") Integer pageNum,
                           Model model) {
        PageHelper.startPage(pageNum, 5);//
        List<Blog> blogList = blogService.getAllBlogs();
        PageInfo blogPageInfo = new PageInfo(blogList);
        model.addAttribute("pageInfo", blogPageInfo);
        return "admin/blogs";
    }

    /**
     * 新增博客
     * @param model
     * @return
     */
    @GetMapping("/input")
    public String toInputView(Model model) {
        model.addAttribute("blog", new Blog());
        List<Type> types = typeService.getAllTypes();
        List<Tag> tags = tagService.getAllTags();
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);
        return "admin/blog-input";
    }

    /**
     * 更新
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}/input")
    public String toUpdateBlog(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog",blog);
        List<Type> types = typeService.getAllTypes();
        List<Tag> tags = tagService.getAllTags();
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);

        return "admin/blog-input";
    }
    /**
     * 编辑/保存 博客
     * @param blog
     * @param session
     * @param attributes
     * @return
     */
    @PostMapping()
    public String saveBlog(Blog blog, HttpSession session, RedirectAttributes attributes) {
        User user = (User) session.getAttribute("user");
        Type type = typeService.selectById(blog.getType().getId());
        List<Tag> tags = tagService.selectByIds(blog.getTagIds());
        blog.setUser(user);
        blog.setUserId(user.getId());
        blog.setType(type);
        blog.setTypeId(type.getId());
        blog.setTags(tags);
        if (blog.getId() == null) {
            blogService.saveBlog(blog);
        } else {
            blogService.updateBlog(blog);
        }
        attributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/admin/blogs";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id,RedirectAttributes attributes){
        blogService.deleteBlogById(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/blogs";
    }
}
