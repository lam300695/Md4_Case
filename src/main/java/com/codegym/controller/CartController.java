package com.codegym.controller;

import com.codegym.model.ShoppingCart;
import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add/{id}")
    public String addProduct(Model model, @PathVariable Long id, HttpSession session){
        HashMap<Long, ShoppingCart> cartItems = (HashMap<Long, ShoppingCart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product != null){
            if (cartItems.containsKey(id)) {
                ShoppingCart item = cartItems.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(id, item);
            } else {
                ShoppingCart item = new ShoppingCart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(id, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartNum", cartItems.size());
        return "product/cart";
    }

    @RequestMapping(value = "sub/{id}", method = RequestMethod.GET)
    public String viewUpdate(ModelMap mm, HttpSession session, @PathVariable("id") Long id) {
        HashMap<Long, ShoppingCart> cartItems = (HashMap<Long, ShoppingCart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);
        return "product/cart";
    }




}
