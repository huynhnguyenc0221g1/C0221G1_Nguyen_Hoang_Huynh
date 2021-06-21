package com.img_of_the_day.model.repository;

import com.img_of_the_day.model.entity.Comment;

import java.util.List;

public interface ICommentService {
    void save(Comment comment);
    List<Comment> findAll();
    Comment findById(int id);
    void like(int id);
}
