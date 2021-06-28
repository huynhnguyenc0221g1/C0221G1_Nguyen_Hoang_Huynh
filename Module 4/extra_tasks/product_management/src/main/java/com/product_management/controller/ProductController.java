package com.product_management.controller;

import com.product_management.model.dto.ProductDto;
import com.product_management.model.entity.Product;
import com.product_management.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService productServiceImpl;

    @RequestMapping("/")
    public ModelAndView showList(@PageableDefault(value = 3)Pageable pageable,
                                 @RequestParam(value = "nameSearch") Optional<String> nameSearch){
        String searchValue = "";
        if(nameSearch.isPresent()){
            searchValue = nameSearch.get();
        }
        Page<Product> productPage = productServiceImpl.findAll(searchValue,pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList",productPage);
        modelAndView.addObject("searchValue",searchValue);
        modelAndView.addObject("productDto",new ProductDto());
        return modelAndView;
    }

    @PostMapping("/product/create")
    public String showCreateForm(@Validated @ModelAttribute ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirect) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        if (bindingResult.hasFieldErrors()) {
            return "list";
        } else {
            productServiceImpl.save(product);
            redirect.addFlashAttribute("message", "Successfully Created The Product!");
            return "redirect:/";
        }
    }

    @GetMapping("/product/edit")
    public String showEditForm(@RequestParam int id, Model model){
        model.addAttribute("product",productServiceImpl.findById(id));
        return "edit";
    }

    @PostMapping(value = "/product/update")
    public String save(@Validated @ModelAttribute ProductDto productDto, BindingResult bindingResult){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            productServiceImpl.update(product);
            return "redirect:/";
        }
    }

    @PostMapping("/product/delete")
    public String showDeleteForm(@RequestParam int id, RedirectAttributes redirect){
        redirect.addFlashAttribute("message","Successfully Deleted The Product!");
        productServiceImpl.remove(id);
        return "redirect:/";
    }
    @GetMapping("product/view")
    public String showView(@RequestParam int id, Model model){
        model.addAttribute("product",productServiceImpl.findById(id));
        return "view";
    }
}
