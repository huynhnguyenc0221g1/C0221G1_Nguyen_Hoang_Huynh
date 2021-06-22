package com.blog.controller;
import java.util.List;
import java.util.Optional;
import com.blog.entity.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "index";
    }

    @RequestMapping(value = "add")
    public String showCreateForm(Model model) {
        model.addAttribute("blog",new Blog());
        return "add";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam("id") Long blogId, Model model) {
        Optional<Blog> blogEdit = blogService.findBlogById(blogId);
        blogEdit.ifPresent(blog -> model.addAttribute("blog",blog));
        return "edit";
    }

    @PostMapping(value = "save")
    public String save(Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String showDeleteForm(@RequestParam("id") Long blogId, Model model) {
        blogService.deleteBlog(blogId);
        return "redirect:/";
    }

    @GetMapping(value = "/view")
    public String showView(@RequestParam("id") Long blogId, Model model) {
        Optional<Blog> blogEdit = blogService.findBlogById(blogId);
        blogEdit.ifPresent(blog -> model.addAttribute("blog",blog));
        return "view";
    }
}
