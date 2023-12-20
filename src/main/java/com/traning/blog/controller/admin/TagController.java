package com.traning.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.traning.blog.pojo.Tag;
import com.traning.blog.service.TagService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/tags")
public class TagController {

    @Resource
    private TagService tagService;


    @GetMapping()
    public String getAllTags(@RequestParam(required = false,defaultValue = "1",value = "pagenum")Integer pagenum, Model model){
        PageHelper.startPage(pagenum,5);
        List<Tag> allTags = tagService.getAllTags();
        PageInfo pageInfo = new PageInfo(allTags);

        model.addAttribute("pageInfo",pageInfo);

        return "admin/tags";
    }

    @GetMapping("/input")
    public String toAddTagView(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    @PostMapping()
    public String addTag(Tag tag, RedirectAttributes attributes){
       Tag selectTag =  tagService.getTagByName(tag.getName());
       if(selectTag != null){
           attributes.addAttribute("msg","标签已存在");
           return "redirect:/admin/tags/input";
       }
       tagService.addTag(tag);
       attributes.addAttribute("msg","添加成功");
       return "redirect:/admin/tags";
    }

    @GetMapping("/{id}/input")
    public String toUpdateView(@PathVariable("id") Long id, Model model){
        Tag tag = tagService.selectById(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    @PostMapping("/{id}")
    public String updateTag(@PathVariable("id")Long id,Tag tag,RedirectAttributes attributes){
        Tag selectTag =  tagService.getTagByName(tag.getName());
        if(selectTag != null){
            attributes.addAttribute("msg","标签已存在");
            return "redirect:/admin/tags/input";
        }
        tagService.updateTag(tag);
        attributes.addAttribute("msg","修改成功");
        return "redirect:/admin/tags";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/tags";
    }
}
