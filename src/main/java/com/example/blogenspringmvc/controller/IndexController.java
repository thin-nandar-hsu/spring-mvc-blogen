package com.example.blogenspringmvc.controller;

import com.example.blogenspringmvc.entity.Category;
import com.example.blogenspringmvc.entity.Post;
import com.example.blogenspringmvc.entity.Users;
import com.example.blogenspringmvc.service.CategoryService;
import com.example.blogenspringmvc.service.PostService;
import com.example.blogenspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("category",new Category());
        model.addAttribute("user",new Users());
        model.addAttribute("post",new Post());
        model.addAttribute("allUser",userService.findAllUsers());
        model.addAttribute("allCategories",categoryService.findAllCategory());
        model.addAttribute("posts",postService.findAllPosts());


        return "home";
    }
}
