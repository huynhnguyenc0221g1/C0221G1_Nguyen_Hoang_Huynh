package com.blog.service.impl;

import com.blog.entity.Blog;
import com.blog.repository.IBlogRepository;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> getAllBlog(Pageable pageable) {
        return (Page<Blog>) iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> listBlog() {
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

    @Override
    public Page<Blog> searchBlogByTitle(String nameTitle, Pageable pageable) {
        return iBlogRepository.searchBlogByTitle(nameTitle,pageable);
    }

    @Override
    public List<Blog> searchBlogByCategory(String nameCategory) {
        return iBlogRepository.searchBlogByCategory(nameCategory);
    }


}
