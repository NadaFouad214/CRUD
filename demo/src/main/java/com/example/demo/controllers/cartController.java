package com.example.demo.controllers;

import com.example.demo.DTO.CartDto;
import com.example.demo.classes.Cart;
import com.example.demo.classes.customer;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cart")
public class cartController {
  private final CartService cartService;
    @Autowired
    public cartController(CartService cartService) {
        this.cartService = cartService;
    }

    //adding
    @PostMapping
    public void AddToCart(@RequestBody CartDto cartDto) throws Exception {
        cartService.addToCart(cartDto);
    }

    @GetMapping
    public List<Cart> getAllCarts(){
    return cartService.getAllCarts();
    }


}
