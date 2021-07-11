package com.controller;

import com.dto.ContractDto;
import com.model.entity.contract.Contract;
import com.model.entity.customer.Customer;
import com.model.entity.employee.Employee;
import com.model.entity.service.Service;
import com.model.service.IContractService;
import com.model.service.ICustomerService;
import com.model.service.IEmployeeService;
import com.model.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IService service;

    @ModelAttribute("customers")
    public Page<Customer> customerPage(Pageable pageable){
        return customerService.findAll("",pageable);
    }
    @ModelAttribute("employees")
    public Page<Employee> employeePage(Pageable pageable){
        return employeeService.findAll("",pageable);
    }
    @ModelAttribute("services")
    public Page<Service> servicePage(Pageable pageable){
        return service.findAll("",pageable);
    }


    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("keyWord") Optional<String> keyWord,
                               @RequestParam("page") Optional<Integer> page) {
        Pageable pageable= PageRequest.of(page.orElse(0),5);
        Page<Contract> contracts = contractService.findAll(keyWord.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("customerUsingService/list","contracts",contracts);
        modelAndView.addObject("keyWord", keyWord.orElse(""));
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String createContract(@ModelAttribute @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","Create new contract successfully!!!");
        return "contract/create";
    }
}
