package com.blog.controller;

import com.blog.entity.Category;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/categoryRest")
@RestController
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = {"/","/list"})
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = this.categoryService.findAllCategories();

        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
}
