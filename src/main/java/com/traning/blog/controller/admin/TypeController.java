package com.traning.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.traning.blog.pojo.Type;
import com.traning.blog.service.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/types")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping()
    public String getType(@RequestParam(required = false, defaultValue = "1", value = "pagenum") Integer pagenum, Model model) {
        PageHelper.startPage(pagenum, 5);
        List<Type> allTypes = typeService.getAllTypes();
        PageInfo pageInfo = new PageInfo(allTypes);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/type";
    }

    @GetMapping("/input")
    public String toInputView(Model model) {
        model.addAttribute("type", new Type());
        return "admin/type-input";
    }

    @GetMapping("{id}/input")
    public String toUpdate(@PathVariable("id") Long id, Model model) {
        Type type = typeService.selectById(id);
        model.addAttribute("type", type);
        return "admin/type-input";
    }

    @PostMapping()
    public String addType(Type type, RedirectAttributes attributes) {
        String name = type.getName();
        Type selectType = typeService.getTypeByName(name);
        if (selectType != null){
            attributes.addAttribute("msg","类型已存在");
            return "redirect:/admin/types/input";
        }
        typeService.addType(type);
        attributes.addAttribute("msg","添加成功");
        return "redirect:/admin/types";
    }

    @PostMapping("/{id}")
    public String updateType(@PathVariable("id") Long id,Type type,RedirectAttributes attributes){
        String name = type.getName();
        Type selectType = typeService.getTypeByName(name);
        if (selectType != null){
            attributes.addAttribute("msg","类型已存在");
            return "redirect:/admin/types/input";
        }
        typeService.updateType(type);
        attributes.addAttribute("msg","修改成功");
        return "redirect:/admin/types";
    }

    @GetMapping("{id}/delete")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes attributes) {
        typeService.deleteById(id);
        attributes.addAttribute("msg", "删除成功");
        return "redirect:/admin/types";
    }

}
