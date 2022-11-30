package com.example.demo.services;

import com.example.demo.DTO.customerdto;
import com.example.demo.classes.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class customerService {
    private final com.example.demo.reposatries.customerReposatory customerReposatory;
    @Autowired
    public customerService(com.example.demo.reposatries.customerReposatory customerReposatory) {
        this.customerReposatory = customerReposatory;
    }
    public customer getCustomer(Long id) throws Exception {
        Optional<customer> customer= customerReposatory.findById(id);
        if(!customer.isPresent()){
            throw new Exception("customer not found");
        }
        return customer.get();
    }



    //adding_product
        public void addcustomer(customerdto customerdto) {
        customer customer =new customer();
        customer.setName(customerdto.getName());
        customer.setEmail(customerdto.getEmail());

        customerReposatory.save(customer);
    }

    public customerdto getcustomerDto(customer customer) {
        customerdto customerdto = new customerdto();
        customerdto.setName(customer.getName());
        customerdto.setEmail(customer.getEmail());
        customerdto.setCustomer_id(customer.getId());
        return customerdto;
    }

    public List<customerdto> getAllcustomers() {
        List<customer> allcustomer= customerReposatory.findAll();
        List<customerdto> customerdto = new ArrayList<>();
        for(customer customer: allcustomer) {
            customerdto.add(getcustomerDto(customer));
        }
        return customerdto;
    }

    //delete
    public void deletecustomer(Long customerid) {
        boolean exists = customerReposatory.existsById(customerid);
        if (!exists)
        {
            throw new IllegalStateException("customer with id "+ customerid +"does not exists");
        }

        customerReposatory.deleteById(customerid);
    }

    public void updatecustomer(customerdto customerdto, Long customerId) throws Exception {

        Optional<customer> optionalcustomer = customerReposatory.findById(customerId);
        if (!optionalcustomer.isPresent()) {
            throw new Exception("customer not present");
        }
        customer customer = optionalcustomer.get();
        customer.setName(customerdto.getName());
        customer.setEmail(customerdto.getEmail());
        customerReposatory.save(customer);

    }
}
