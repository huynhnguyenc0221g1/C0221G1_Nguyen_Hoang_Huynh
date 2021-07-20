package com.final_exam.controller;

import com.final_exam.dto.QuestionDto;
import com.final_exam.model.entity.Question;
import com.final_exam.model.entity.QuestionType;
import com.final_exam.model.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/","questions"})
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @ModelAttribute("questionTypes")
    public List<QuestionType> questionTypes() {
        return questionService.listQuestionType();
    }

    @GetMapping(value = {""})
    public ModelAndView showQuestionList(@RequestParam("keyWord")Optional <String> keyWord, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),5);
        Page<Question> questions = questionService.findAll(keyWord.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("list","questions",questions);
        modelAndView.addObject("keyWord",keyWord.orElse(""));
        return modelAndView;
    }

    @GetMapping(value = "create")
    public String showCreateForm(Model model){
        model.addAttribute("questionDto",new QuestionDto());
        return "create";
    }

    @PostMapping(value = "create")
    public String createQuestion(@ModelAttribute @Valid QuestionDto questionDto,
                                 BindingResult bindingResult ,
                                 RedirectAttributes redirectAttributes){
        new QuestionDto().validate(questionDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        this.questionService.save(question);
        redirectAttributes.addFlashAttribute("msg","Successfully created new question!");
        return "redirect:/questions";
    }

    @GetMapping(value = "edit")
    public String showEditForm(@RequestParam Long id, Model model){
        Question question = this.questionService.findById(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question,questionDto);
        model.addAttribute("questionDto",questionDto);
        return "edit";
    }

    @GetMapping(value = "view")
    public String showViewForm(@RequestParam Long id, Model model){
        Question question = this.questionService.findById(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question,questionDto);
        model.addAttribute("questionDto",questionDto);
        return "view";
    }

    @PostMapping(value = "edit")
    public String editQuestion(@ModelAttribute @Valid QuestionDto questionDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new QuestionDto().validate(questionDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "edit";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg","Successfully updated question's information!!");
        return "redirect:/questions";
    }

    @PostMapping(value = "delete")
    public String deleteQuestion(@RequestParam Long id,RedirectAttributes redirectAttributes){
        this.questionService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Successfully deleted the question!");
        return "redirect:/questions";
    }
}

