package com.blog.service;

import com.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> getAllBlog(Pageable pageable);

    List<Blog> listBlog();

    void saveBlog(Blog blog);

    void deleteBlog(Long id);

    Optional<Blog> findBlogById(Long id);

    Page<Blog> searchBlogByTitle(String nameTitle,Pageable pageable);

    List<Blog> searchBlogByTitle(String nameTitle);

    List<Blog> searchBlogByCategory(String nameCategory);
}
