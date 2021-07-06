package com.codygym.controller;

import com.codygym.model.dto.CustomerDto;
import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.customer.CustomerType;
import com.codygym.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/","/customer"})
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypeList() {
        return customerService.findAllCustomerType();
    }

    @GetMapping(value = "/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Create customer successfully");
        return "redirect:/list";
    }

    @GetMapping(value = "/list")
    public String showListCustomer(Model model,
                                   @PageableDefault(size = 2) Pageable pageable,
                                   @RequestParam Optional<String> keyword) {
        Page<Customer> customerList = customerService.findByName(keyword.orElse(""), pageable);
        model.addAttribute("customers", customerList);
        model.addAttribute("keyword", keyword.orElse(""));
        return "/customer/list";

    }

    @GetMapping(value = "delete")
    public String showDeleteCustomer(@RequestParam Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/delete";

    }

    @PostMapping(value = "delete")
    public String deleteCustomer(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute CustomerDto customerDto,
                                RedirectAttributes redirect) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);

        redirect.addFlashAttribute("success", "Updated product information successfully!");
        return "redirect:/list";
    }

}
