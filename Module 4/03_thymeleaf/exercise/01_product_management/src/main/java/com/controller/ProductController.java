package com.controller;

import com.model.bean.Product;
import com.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/product","/"})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "")
    public String index(Model model) {
        List<Product> productList=productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping(value ="/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        product.setId(productService.findAll().size() + 1);
        productService.save(product);
        redirect.addFlashAttribute("message", "Successfully Created!");
        return "redirect:/product/";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id,Model model) {
      model.addAttribute("product",productService.findById(id));
        return "/edit";
    }


    @PostMapping(value = "/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("message", "Successfully Updated!");
        return "redirect:/product/";
    }


    @PostMapping(value = "/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("message", "Successfully Deleted!");
        return "redirect:/product/";
    }


    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping(value = "/search")
    public String findProduct(@RequestParam String name,Model model){
        model.addAttribute("products",productService.findByName(name));
        return "/index";
    }

}