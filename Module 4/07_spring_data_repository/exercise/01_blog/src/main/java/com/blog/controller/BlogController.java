package com.blog.controller;
import java.util.List;
import java.util.Optional;
import com.blog.entity.Blog;
import com.blog.entity.Category;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @RequestMapping("/")
    public ModelAndView index(@PageableDefault(size = 3) Pageable pageable) {
        Page<Blog> blogs = blogService.getAllBlog(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @RequestMapping(value = "add")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", this.categoryService.findAllCategories());
        return "blog/add";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam("id") Long blogId, Model model) {
        Optional<Blog> blogEdit = blogService.findBlogById(blogId);
        blogEdit.ifPresent(blog -> model.addAttribute("blog", blog));
        model.addAttribute("categories", this.categoryService.findAllCategories());
        return "blog/edit";
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
        blogEdit.ifPresent(blog -> model.addAttribute("blog", blog));
        return "blog/view";
    }

    @GetMapping(value = {"/"})
    public ModelAndView showSearch(@PageableDefault(value = 3) Pageable pageable,
                                   @RequestParam Optional<String> keyword) {
        String titleValue = "";
        if (keyword.isPresent()) {
            titleValue = keyword.get();
        }
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        Page<Blog> blogs = blogService.searchBlogByTitle(titleValue,pageable);
        modelAndView.addObject("titleValue",titleValue);
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
}
