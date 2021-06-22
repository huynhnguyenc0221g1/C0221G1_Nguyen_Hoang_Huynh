package com.blog.service;

import com.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> getAllBlog();

    void saveBlog(Blog blog);

    void deleteBlog(Long id);

    Optional<Blog> findBlogById(Long id);
}
