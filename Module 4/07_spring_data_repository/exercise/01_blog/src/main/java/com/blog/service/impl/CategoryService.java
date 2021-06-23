package com.blog.service.impl;

import com.blog.entity.Category;
import com.blog.repository.ICategoryRepository;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll();
    }
}
