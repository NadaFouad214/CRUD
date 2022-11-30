package com.example.demo.classes;

import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

@Entity
@Table
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private double total_price;
    private int total_quantity;
    @OneToMany
    @JoinColumn(name = "items")
    List<productLine> items =new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal_price() {
        int i=0;
        while(i<items.size()) {

             total_price += items.get(i).getTotal_price_item();
            i++;
        }
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getTotal_quantity() {
        total_quantity=items.size();
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public List<productLine> getItems() {
        return items;
    }

    public void setItems(List<productLine> items) {
        this.items = items;
    }
}
