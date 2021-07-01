package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/blogRest")
@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = {"/","list"})
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.listBlog();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping(value = {"/view/{id}"})
    public ResponseEntity getBlogDetail(@PathVariable Long id) {
        Optional<Blog> blog = this.blogService.findBlogById(id);

        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(blog,HttpStatus.OK);
    }

    @GetMapping(value = {"/list/search/{nameTitle}"})
    public ResponseEntity<List<Blog>> getBlogListByTitle(@PathVariable String nameTitle) {
        List<Blog> blogListByTitle = this.blogService.searchBlogByTitle(nameTitle);

        if (blogListByTitle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogListByTitle,HttpStatus.OK);
    }

    @GetMapping(value = {"/list/{nameCategory}"})
    public ResponseEntity<List<Blog>> getBlogListByCategory(@PathVariable String nameCategory) {
        List<Blog> blogListByCategory = this.blogService.searchBlogByCategory(nameCategory);

        if (blogListByCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogListByCategory,HttpStatus.OK);
    }
}
