package com.traning.blog.controller.admin;

import com.traning.blog.pojo.User;
import com.traning.blog.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;


    @GetMapping()
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session){
        //校验
        User user = userService.login(username,password);
        //跳转
        if(null != user){
            session.setAttribute("user",user);
            return "admin/index";
        }
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
