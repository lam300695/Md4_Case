package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.Type;
import com.codegym.service.ProductService;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @ModelAttribute("types")
    public Iterable<Type> types() {
        return typeService.findAll();
    }

    @GetMapping("/product/list")
    public String showListProduct(Model model, Pageable pageable, @RequestParam("s") Optional<String> s) {
        Page<Product> products;
        if (s.isPresent()) {
            products = productService.findAllByProductNameContaining(s.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
//        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/admin/product/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/product/create")
    public String saveCreate(@ModelAttribute("product") Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Create Success!!!");
        return "/product/create";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (id != null) {
            model.addAttribute("product", product);
        } else {
            return "404";
        }
        return "product/edit";
    }

    @PostMapping("/product/saveEdit")
    public String saveEdit(Model model, @ModelAttribute("product") Product product) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Edit Product Success!!!");
        return "product/edit";
    }

    @GetMapping("/product/delete/{id}")
    public String showFormDelete(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (id != null) {
            model.addAttribute("product", product);
            model.addAttribute("message", "Delete Product Success!!!");
            return "product/delete";
        } else {
            return "404";
        }
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productService.remove(id);
        return "redirect:/product/list";
    }

    @GetMapping("/product/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/samsung")
    public String showListSamSung(Model model, Pageable pageable, String typeName) {
         typeName = "SamSung";
        Page<Product> products= productService.findAllByType_TypeName(typeName,pageable);
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/apple")
    public String showListApple(Model model, Pageable pageable, String typeName) {
        typeName = "Apple";
        Page<Product> products= productService.findAllByType_TypeName(typeName,pageable);
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/nokia")
    public String showListNokia(Model model, Pageable pageable, String typeName) {
        typeName = "NOKIA";
        Page<Product> products= productService.findAllByType_TypeName(typeName,pageable);
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/oppo")
    public String showListOppo(Model model, Pageable pageable, String typeName) {
        typeName = "OPPO";
        Page<Product> products= productService.findAllByType_TypeName(typeName,pageable);
        model.addAttribute("products", products);
        return "product/list";
    }
}
