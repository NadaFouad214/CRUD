package com.example.demo.DTO;

import com.example.demo.classes.Product;

public class ProductLineDto {
private Long id;
private Long product_id;
private int quantity_item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }



    public ProductLineDto() {
    }



    public int getQuantity_item() {
        return quantity_item;
    }

    public void setQuantity_item(int quantity_item) {
        this.quantity_item = quantity_item;
    }
}
