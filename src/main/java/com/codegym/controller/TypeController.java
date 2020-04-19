package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.Type;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/type/list")
    public String showListProduct(Model model) {
        Iterable<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return "type/list";
    }

    @GetMapping("/type/create")
    public String showFormCreate(Model model) {
        model.addAttribute("type", new Type());
        return "/type/create";
    }

    @PostMapping("/type/create")
    public String saveCreate(@ModelAttribute("type") Type type, Model model) {
        typeService.save(type);
        model.addAttribute("type", type);
        model.addAttribute("message", "Create Success!!!");
        return "/type/create";
    }

}
