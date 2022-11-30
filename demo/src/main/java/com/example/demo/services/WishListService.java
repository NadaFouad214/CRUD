package com.example.demo.services;

import com.example.demo.DTO.GetProductLineDto;
import com.example.demo.DTO.ProductDto;
import com.example.demo.DTO.ProductLineDto;
import com.example.demo.classes.Product;
import com.example.demo.classes.WishList;
import com.example.demo.classes.customer;
import com.example.demo.classes.productLine;
import com.example.demo.reposatries.WishListReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WishListService {

   private final WishListReposatory wishListReposatory;

    @Autowired
   private final productService productService;

    public WishListService(WishListReposatory wishListRepository, com.example.demo.services.productService productService) {
        this.wishListReposatory = wishListRepository;
        this.productService = productService;
    }

    public void createWishlist(ProductDto productDto) throws Exception {
        Product product=productService.getProduct(productDto.getId());
        WishList W = new WishList();
        W.setProduct(product);
       wishListReposatory.save(W);
    }


    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        WishList W= new WishList();
        W.setProduct(product);
        WishList savedW = wishListReposatory.save(W);
        productDto.setProduct_description(product.getProduct_description());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setProduct_price(product.getProduct_price());
        productDto.setId(product.getId());
        productDto.setWishlist_id(savedW.getWish_id());

        return productDto;
    }
    public List<ProductDto> getWishLists() {
        final List<WishList> wishLists = wishListReposatory.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (WishList wishList: wishLists) {
            productDtos.add(getProductDto(wishList.getProduct()));
        }
        return productDtos;
    }

    public void deleteWishList(Long wishlistid) {

        boolean exists = wishListReposatory.existsById(wishlistid);
        if (!exists)
        {
            throw new IllegalStateException("wishlist with id "+ wishlistid +"does not exists");
        }
        wishListReposatory.deleteById(wishlistid);
    }


}
