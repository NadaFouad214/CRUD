package com.example.demo.classes;

import javax.persistence.*;

@Entity
@Table
public class WishList {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long wish_id;


@ManyToOne
@JoinColumn(name = "product_id")
private Product product;





    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getWish_id() {
        return wish_id;
    }

    public void setWish_id(Long wish_id) {
        this.wish_id = wish_id;
    }
}
