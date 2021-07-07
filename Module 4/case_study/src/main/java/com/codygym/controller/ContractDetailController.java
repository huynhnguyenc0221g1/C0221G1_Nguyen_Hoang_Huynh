package com.codygym.controller;

import com.codygym.model.dto.ContractDetailDto;
import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.Contract;
import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.service.contract.IAttachServiceService;
import com.codygym.model.service.contract.IContractDetailService;
import com.codygym.model.service.contract.IContractService;
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
@RequestMapping(value = {"/contract-details", "/"})
public class ContractDetailController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachServiceService attachServiceService;
    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute(value = "contracts")
    public Iterable<Contract> contracts() {
        return contractService.findAll();
    }

    @ModelAttribute(value = "attachServices")
    public Iterable<AttachService> attachServices() {
        return attachServiceService.findAll();
    }

    @GetMapping(value = {"/create-contract-detail"})
    public ModelAndView showCreateForm(){
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        ModelAndView modelAndView= new ModelAndView("contract/create-contract-detail");
        modelAndView.addObject("contractDetailDto", contractDetailDto);
        return  modelAndView;
    }

    @PostMapping(value = "/create-contract-detail")
    public ModelAndView saveContractDetail(@Validated @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult){
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);

        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/contract/create-contract-detail");
            modelAndView.addObject(bindingResult.getModel());
            return modelAndView;
        }else {
            contractDetailService.save(contractDetail);
            ModelAndView modelAndView = new ModelAndView("/contract/create-contract-detail");
            modelAndView.addObject("mes","new Contract detail created successfully");
            return modelAndView;
        }
    }
}
