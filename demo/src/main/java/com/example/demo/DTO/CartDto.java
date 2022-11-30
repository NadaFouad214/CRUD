package com.example.demo.DTO;

import org.springframework.lang.NonNull;

public class CartDto {

    private static  Long id;

    public  static Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
