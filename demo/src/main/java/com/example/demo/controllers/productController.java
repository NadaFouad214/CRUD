package com.example.demo.controllers;

import com.example.demo.DTO.ProductDto;
import com.example.demo.classes.Product;
import com.example.demo.reposatries.productReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Product")
public class productController {
    private final com.example.demo.services.productService productService;
    @Autowired
    public productController(com.example.demo.services.productService productService) {
        this.productService = productService;
    }
    //adding
    @PostMapping
    public void new_product(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }
    //deleting
    @DeleteMapping(path= "{Productid}")
    public void deleteProduct(@PathVariable("Productid") Long Productid)
    {
        productService.deleteProduct(Productid);
    }

    //get product
    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return products;
    }

    // updating
    @PostMapping("/update/{productId}")
    public void updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) throws Exception {

        productService.updateProduct(productDto, productId);

    }


}
