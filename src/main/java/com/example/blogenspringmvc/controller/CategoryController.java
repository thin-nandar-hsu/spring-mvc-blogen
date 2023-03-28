package com.example.blogenspringmvc.controller;

import com.example.blogenspringmvc.entity.Category;
import com.example.blogenspringmvc.entity.Users;
import com.example.blogenspringmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/show-category")
    public String showCategories(Model model){
        model.addAttribute("categories",categoryService.findAllCategory());
        return "categories";
    }


    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result){
        if(result.hasErrors()){
            return "home";
        }
        categoryService.saveCategory(category);
           return "redirect:/";

    }


}
