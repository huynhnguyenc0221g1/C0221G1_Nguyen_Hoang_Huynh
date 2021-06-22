package com.blog.service.impl;

import com.blog.entity.Blog;
import com.blog.repository.IBlogRepository;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findBlogById(Long id) {
        return iBlogRepository.findById(id);
    }
}
