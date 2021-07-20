package com.final_exam.model.service;

import com.final_exam.model.entity.Question;
import com.final_exam.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
    Page<Question> findAll(String keyWord, Pageable pageable);
    Question findById(Long id);
    void save(Question question);
    void remove(Long id);
    List<QuestionType> listQuestionType();
}
