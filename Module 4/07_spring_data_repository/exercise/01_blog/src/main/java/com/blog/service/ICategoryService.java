package com.blog.service;

import com.blog.entity.Blog;
import com.blog.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAllCategories();
}
