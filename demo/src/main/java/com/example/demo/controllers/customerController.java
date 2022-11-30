package com.example.demo.controllers;

import com.example.demo.DTO.ProductDto;
import com.example.demo.DTO.customerdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class customerController {
    private final com.example.demo.services.customerService customerService;
    @Autowired
    public customerController(com.example.demo.services.customerService customerService) {
        this.customerService = customerService;
    }


    //adding
    @PostMapping
    public void new_customer(@RequestBody customerdto customerdto){
        customerService.addcustomer(customerdto);
    }

    //get customer
    @GetMapping
    public List<customerdto> getcustomer() {
        List<customerdto> customer = customerService.getAllcustomers();
        return customer;
    }


    //deleting
    @DeleteMapping(path= "{customerid}")
    public void deletecustomer(@PathVariable("customerid") Long customerid)
    {
        customerService.deletecustomer(customerid);
    }


    // updating
    @PostMapping("/update/{customerId}")
    public void updatecustomer(@PathVariable("customerId") Long customerId, @RequestBody customerdto customerdto) throws Exception {

        customerService.updatecustomer(customerdto, customerId);

    }

}
