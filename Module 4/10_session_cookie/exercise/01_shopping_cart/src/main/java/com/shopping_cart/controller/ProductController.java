package com.shopping_cart.controller;

import com.shopping_cart.model.entity.Cart;
import com.shopping_cart.model.entity.Product;
import com.shopping_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping(value= {"/", "/shop"})
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, Model model) {
        Product product = productService.findById(id).get();
        if (product == null ) {
            return "error.404";
        }
        cart.addProduct(product);
        model.addAttribute("product",product);
        return "redirect:/shop";
    }

    @GetMapping("/view/{id}")
    public String showViewProduct(@PathVariable Long id, @ModelAttribute Cart cart,
                                  Model model) {
        Product product = productService.findById(id).get();
        if (product == null ) {
            return "error.404";
        }
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute Cart cart){
        Product product = productService.findById(id).get();
        if (product == null ) {
            return "error.404";
        }
        cart.removeProduct(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/change/{id}")
    public String changeCountProduct(@PathVariable Long id,
                                     @ModelAttribute Cart cart,
                                     @RequestParam("action") String action){
        Product product = productService.findById(id).get();
        if (product == null ) {
            return "error.404";
        }
        cart.changeCount(product,action);
        return "redirect:/shopping-cart";
    }
}
