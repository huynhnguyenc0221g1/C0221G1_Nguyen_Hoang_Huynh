package com.img_of_the_day.controller;

import com.img_of_the_day.model.entity.Comment;
import com.img_of_the_day.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"", "/comment"})
public class CommentController {
    @Autowired
    ICommentService iCommentService;

    @GetMapping(value = "")
    public String comment(Model model) {
        List<Comment> comments = iCommentService.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "/comment";
    }

    @PostMapping("/save")
    public String comment(@ModelAttribute("comment") Comment comment) {
        iCommentService.save(comment);
        return "redirect:/comment/";
    }

    @GetMapping("/like")
    public String like(@RequestParam int id) {
        iCommentService.like(id);
        return "redirect:/comment/";
    }
}
