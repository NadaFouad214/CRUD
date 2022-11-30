package com.example.demo.services;

import com.example.demo.DTO.CartDto;
import com.example.demo.DTO.GetCartDto;
import com.example.demo.classes.Cart;
import com.example.demo.classes.customer;
import com.example.demo.reposatries.customerReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final com.example.demo.reposatries.cartReposatory cartReposatory;
    private final productLineService productLineService;
    private final customerService customerService;
    @Autowired
    private customerReposatory customerReposatory;


    @Autowired
    public CartService(com.example.demo.reposatries.cartReposatory cartReposatory, com.example.demo.services.productLineService productLineService, com.example.demo.services.customerService customerService, com.example.demo.reposatries.customerReposatory customerReposatory) {
        this.cartReposatory = cartReposatory;
        this.productLineService = productLineService;
        this.customerService = customerService;
        this.customerReposatory = customerReposatory;
    }

    public void addToCart(CartDto cartDto) throws Exception {

        Cart cart = new Cart();
        cart.setItems(productLineService.getallproductlines());

        customer c= customerService.getCustomer(cartDto.getId());

        c.setCustomerCart(cart);

        cartReposatory.save(cart);
        customerReposatory.save(c);


    }

    public List<Cart> getAllCarts (){
        return cartReposatory.findAll();
    }

    public GetCartDto getCart(Long id) throws Exception {
        GetCartDto getCartDto =new GetCartDto();
        customer customer= customerService.getCustomer(id);
        Cart cart=customer.getCustomerCart();
        getCartDto.setTotal_price(cart.getTotal_price());
        getCartDto.setTotal_quantity(cart.getTotal_quantity());

        return getCartDto;
    }
}
