package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Category;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @RequestMapping("/category")
    public ModelAndView index() {
        List<Category> categories = categoryService.findAllCategories();
        ModelAndView modelAndView = new ModelAndView("/index_category");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @RequestMapping(value = "addCategory")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "add_category";
    }

    @GetMapping(value = "editCategory")
    public String showEditForm(@RequestParam("id") Integer categoryId, Model model) {
        Optional<Category> categoryEdit = categoryService.findCategoryById(categoryId);
        categoryEdit.ifPresent(category -> model.addAttribute("category", category));
        return "edit_category";
    }

    @PostMapping(value = "saveCategory")
    public String save(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping(value = "deleteCategory")
    public String showDeleteForm(@RequestParam("id") Integer categoryId, Model model) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/category";
    }

}
