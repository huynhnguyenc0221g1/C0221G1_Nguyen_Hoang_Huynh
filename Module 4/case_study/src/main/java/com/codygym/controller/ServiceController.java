package com.codygym.controller;

import com.codygym.model.dto.ServiceDto;
import com.codygym.model.entity.service.RentType;
import com.codygym.model.entity.service.Service;
import com.codygym.model.entity.service.ServiceType;
import com.codygym.model.service.service.IRentTypeService;
import com.codygym.model.service.service.IServiceService;
import com.codygym.model.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/services", "/"})
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute(value = "serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }


    @ModelAttribute(value = "rentTypes")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }


    @GetMapping(value = {"/create-service"})
    public ModelAndView showCreateForm() {
        ServiceDto serviceDto = new ServiceDto();
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceDto", serviceDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-service")
    public ModelAndView saveService(@Validated @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult) {
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/service/create");
            modelAndView.addObject("mes", "new service created successfully");
            return  modelAndView;
        }else {
            serviceService.save(service);
            ModelAndView modelAndView = new ModelAndView("/service/create");
            modelAndView.addObject("mes", "new service created successfully");
            return modelAndView;
        }
    }
}
