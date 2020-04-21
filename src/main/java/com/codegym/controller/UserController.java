package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.model.Type;
import com.codegym.model.User;
import com.codegym.service.RoleService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @ModelAttribute("roles")
    public Iterable<Role> types() {
        return roleService.findAll();
    }

    @GetMapping("/signin")
    public String getSigninForm(){
        return "login/login";
    }

    @GetMapping("/registration")
    public String user(Model model){
        model.addAttribute("user",new User());
        return "/product/registration";
    }

    @PostMapping("/saveRegistration")
    public String save(@ModelAttribute("user") User user, Model model){
        userService.save(user);
        model.addAttribute("user",user);
        model.addAttribute("message","create Accout Success!!!");
        return "/product/registration";
    }

    @GetMapping("/manageUser")
    public String MannageUser(Model model){
        Iterable<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "product/manageUser";
    }

    @GetMapping("/log")
    public String Log(){
        return "login/adminOrUser";
    }
}
