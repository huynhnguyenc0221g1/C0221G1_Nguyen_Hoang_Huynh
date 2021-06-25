package com.form.controller;

import com.form.model.dto.UserDto;
import com.form.model.entity.User;
import com.form.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = {"/" , "/index"})
    public ModelAndView showCreateForm() {
        return new ModelAndView("/index" , "userDto", new UserDto());
    }

    @PostMapping(value = {"/result"})
    public ModelAndView showResult(@Validated @ModelAttribute UserDto userDto, BindingResult result) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        if (result.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/index");
            modelAndView.addAllObjects(result.getModel());
            return modelAndView;
        } else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("/result","user",user);
            return modelAndView;
        }
    }
}
