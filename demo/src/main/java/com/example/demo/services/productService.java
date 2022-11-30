package com.example.demo.services;

import com.example.demo.DTO.ProductDto;
import com.example.demo.classes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class productService {
    private final com.example.demo.reposatries.productReposatory productReposatory;
    @Autowired
    public productService(com.example.demo.reposatries.productReposatory productReposatory) {
        this.productReposatory = productReposatory;
    }

    //adding_product
    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProduct_description(productDto.getProduct_description());
        product.setProduct_name(productDto.getProduct_name());
        product.setProduct_price(productDto.getProduct_price());
        productReposatory.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProduct_description(product.getProduct_description());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setProduct_price(product.getProduct_price());
        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productReposatory.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product: allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void deleteProduct(Long productid) {
        boolean exists = productReposatory.existsById(productid);
        if (!exists)
        {
            throw new IllegalStateException("product with id "+ productid +"does not exists");
        }

        productReposatory.deleteById(productid);
    }

    public void updateProduct(ProductDto productDto, Long productId) throws Exception {

        Optional<Product> optionalProduct = productReposatory.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
        product.setProduct_description(productDto.getProduct_description());
        product.setProduct_name(productDto.getProduct_name());
        product.setProduct_price(productDto.getProduct_price());
        productReposatory.save(product);
    }
    public Product getProduct(Long productId) throws Exception {
        Optional<Product> optionalProduct = productReposatory.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        return optionalProduct.get();
    }
}
