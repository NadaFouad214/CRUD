package com.example.demo.classes;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class productLine  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Product item ;
    private int quantity_item;
    private double total_price_item;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity_item() {
        return quantity_item;
    }

    public void setQuantity_item(int quantity_item) {
        this.quantity_item = quantity_item;
    }

    public double getTotal_price_item() {

        return total_price_item=item.getProduct_price()*getQuantity_item() ;
    }

    public void setTotal_price_item(double total_price_item) {
        this.total_price_item = total_price_item;
    }
}
