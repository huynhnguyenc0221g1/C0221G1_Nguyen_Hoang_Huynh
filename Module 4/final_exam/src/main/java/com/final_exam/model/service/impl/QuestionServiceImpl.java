package com.final_exam.model.service.impl;

import com.final_exam.model.entity.Question;
import com.final_exam.model.entity.QuestionType;
import com.final_exam.model.repository.IQuestionRepository;
import com.final_exam.model.repository.IQuestionTypeRepository;
import com.final_exam.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Override
    public Page<Question> findAll(String keyWord, Pageable pageable) {
        return questionRepository.findAllByKeyWord(keyWord,pageable);
    }

    @Override
    public Question findById(Long id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        this.questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        Question question = this.findById(id);
        question.setFlag(false);
        save(question);
    }

    @Override
    public List<QuestionType> listQuestionType() {
        return questionTypeRepository.findAll();
    }

}
