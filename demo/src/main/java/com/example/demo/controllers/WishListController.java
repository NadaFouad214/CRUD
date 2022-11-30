package com.example.demo.controllers;


import com.example.demo.DTO.ProductDto;
import com.example.demo.DTO.ProductLineDto;
import com.example.demo.classes.Product;
import com.example.demo.classes.WishList;
import com.example.demo.classes.customer;
import com.example.demo.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wishlist")
public class WishListController {

   private final WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @PostMapping
    public void addToWishList(@RequestBody ProductDto productDto)throws Exception {

        wishListService.createWishlist(productDto);

    }
    @GetMapping
    public List<ProductDto> getWishList() {

        List<ProductDto> productDtos = wishListService.getWishLists();
        return productDtos;

    }
    //deleting
    @DeleteMapping(path="{wishlistid}")
    public void deleteProduct(@PathVariable("wishlistid") Long wishlistid)
    {
       wishListService.deleteWishList(wishlistid);
    }



}
