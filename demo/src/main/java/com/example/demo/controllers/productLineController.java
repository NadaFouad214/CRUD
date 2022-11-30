package com.example.demo.controllers;

import com.example.demo.DTO.GetProductLineDto;
import com.example.demo.DTO.ProductDto;
import com.example.demo.DTO.ProductLineDto;
import com.example.demo.classes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ProductLine")
public class productLineController {
    private final com.example.demo.services.productLineService productLineService;
    @Autowired
    public productLineController(com.example.demo.services.productLineService productLineService) {
        this.productLineService = productLineService;
    }

    //adding
    @PostMapping
    public void AddToProductLine(@RequestBody ProductLineDto productLineDto) throws Exception {

       productLineService.addToProductLine(productLineDto);
    }

    @GetMapping
    public List<GetProductLineDto> getProductsline() throws Exception {
        List<GetProductLineDto> productsLine = productLineService.getAllProductsLine();
        return productsLine;
    }


    //deleting
    @DeleteMapping(path= "{Productlineid}")
    public void deleteProduct(@PathVariable("Productlineid") Long Productlineid)
    {
        productLineService.deleteProductLine(Productlineid);
    }

   // updating
   @PostMapping("/update/{Productlineid}")
   public void updateProduct(@PathVariable("Productlineid") Long productlineId, @RequestBody ProductLineDto productLineDto) throws Exception {

       productLineService.updateProduct(productLineDto, productlineId);

   }


}
