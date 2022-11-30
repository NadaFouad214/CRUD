package com.example.demo.DTO;

public class GetProductLineDto {


    private Long id_productLine;
//    private Long product_id;
    private int quantity_item;
    private double total_price_item;

    public GetProductLineDto() {
    }

    public Long getId_productLine() {
        return id_productLine;
    }

    public void setId_productLine(Long id_productLine) {
        this.id_productLine = id_productLine;
    }

//    public Long getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(Long product_id) {
//        this.product_id = product_id;
//    }

    public int getQuantity_item() {
        return quantity_item;
    }

    public void setQuantity_item(int quantity_item) {
        this.quantity_item = quantity_item;
    }

    public double getTotal_price_item() {
        return total_price_item;
    }

    public void setTotal_price_item(double total_price_item) {
        this.total_price_item = total_price_item;
    }
}
