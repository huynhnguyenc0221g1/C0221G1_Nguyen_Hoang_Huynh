package com.codygym.controller;

import com.codygym.model.dto.ContractDto;
import com.codygym.model.entity.contract.Contract;
import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.service.Service;
import com.codygym.model.service.contract.IContractService;
import com.codygym.model.service.customer.ICustomerService;
import com.codygym.model.service.employee.IEmployeeService;
import com.codygym.model.service.service.IServiceService;
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
@RequestMapping(value = {"/contracts","/"})
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;
    @ModelAttribute(value = "customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }
    @ModelAttribute(value = "employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute(value = "services")
    public Iterable<Service> services() {
        return serviceService.findAll();
    }

    @GetMapping(value = {"/create-contract"})
    public ModelAndView showCreateForm() {
        ContractDto contractDto = new ContractDto();
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", contractDto);
        return modelAndView;
    }
    @PostMapping(value = "/create-contract")
    public ModelAndView saveContract(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/contract/create");
            return modelAndView;
        } else {
            contractService.save(contract);
            ModelAndView modelAndView = new ModelAndView("/contract/create");
            modelAndView.addObject("mes", "new employee created successfully");
            return modelAndView;
        }
    }
}
