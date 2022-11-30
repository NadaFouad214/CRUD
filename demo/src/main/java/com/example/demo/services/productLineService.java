package com.example.demo.services;

import com.example.demo.DTO.GetProductLineDto;
import com.example.demo.DTO.ProductDto;
import com.example.demo.DTO.ProductLineDto;
import com.example.demo.classes.Product;
import com.example.demo.classes.productLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class productLineService {
    private final com.example.demo.reposatries.productLineReposatory productLineReposatory;
    private final productService productService;
    @Autowired
    public productLineService(com.example.demo.reposatries.productLineReposatory productLineReposatory, com.example.demo.services.productService productService) {
        this.productLineReposatory = productLineReposatory;
        this.productService = productService;
    }
    //add
    public void addToProductLine(ProductLineDto productLineDto) throws Exception {
        Product product=productService.getProduct(productLineDto.getProduct_id());
        productLine productLine=new productLine();
        productLine.setItem(product);
        productLine.setQuantity_item(productLineDto.getQuantity_item());
        productLineReposatory.save(productLine);
    }
    public List<productLine>getallproductlines(){
       return productLineReposatory.findAll();
    }

    public GetProductLineDto getProductDto(productLine productLine) throws Exception {

        GetProductLineDto getProductLineDto  = new GetProductLineDto();
        getProductLineDto.setId_productLine(productLine.getId());
        getProductLineDto.setQuantity_item(productLine.getQuantity_item());
        getProductLineDto.setTotal_price_item(productLine.getTotal_price_item());
        return getProductLineDto;
    }


    public List<GetProductLineDto> getAllProductsLine() throws Exception {

        List<productLine> allProductsLins = productLineReposatory.findAll();
        List<GetProductLineDto> getProductLineDtos= new ArrayList<>();
        for(productLine productLine: allProductsLins) {
            getProductLineDtos.add(getProductDto(productLine));
        }
        return getProductLineDtos;
    }

    public void deleteProductLine(Long productlineid) {

        boolean exists = productLineReposatory.existsById(productlineid);
        if (!exists)
        {
            throw new IllegalStateException("productline with id "+ productlineid +"does not exists");
        }

        productLineReposatory.deleteById(productlineid);

    }


    public void updateProduct(ProductLineDto productLineDto, Long productlineId) throws Exception {

        Optional<productLine> optionalProductline = productLineReposatory.findById(productlineId);
        if (!optionalProductline.isPresent()) {
            throw new Exception("productline not present");
        }
        productLine productLine = optionalProductline.get();
        productLine.setQuantity_item(productLineDto.getQuantity_item());
        productLine.setTotal_price_item(productLineDto.getQuantity_item()*productLine.getItem().getProduct_price());
        productLineReposatory.save(productLine);

    }


}
