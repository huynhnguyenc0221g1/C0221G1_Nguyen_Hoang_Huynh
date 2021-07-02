package com.customer_management.controller;

import com.customer_management.exception.DuplicateEmailException;
import com.customer_management.model.entity.Customer;
import com.customer_management.model.entity.Province;
import com.customer_management.model.service.ICustomerService;
import com.customer_management.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IProvinceService iProvinceService;
    @GetMapping("/")
    public String display(Model model, @PageableDefault(size = 5) Pageable pageable){
        Page<Customer> customerList=iCustomerService.findAll(pageable);
        List<Province> provinceList=iProvinceService.findAll();
        model.addAttribute("customerList",customerList);
        model.addAttribute("provinceList",provinceList);
        return "/index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        List<Province> provinceList=iProvinceService.findAll();
        model.addAttribute("provinceList",provinceList);
        return "/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) throws DuplicateEmailException {
        try {
            iCustomerService.save(customer);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }

    }
    @GetMapping("/edit")
    public String showEditform(@RequestParam Integer id, Model model){
        Customer customer=iCustomerService.findById(id);
        List<Province> provinceList=iProvinceService.findAll();
        model.addAttribute("provinceList",provinceList);
        model.addAttribute("customer",customer);

        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Integer id, Model model){
        Customer customer=iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id){
        iCustomerService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/search")
    public String search(@RequestParam String search, @PageableDefault(size = 5)Pageable pageable, Model model){
        Page<Customer> list=iCustomerService.findAllByNameContaining(search,pageable);
        model.addAttribute("customerList",list);

        return "/index";
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public String showError(){
        return "error";
    }
}