package com.luxin.base.domain;

import java.io.Serializable;

public class Product implements Serializable {


    public Product() {
    }

    private Long id;

    private String productName;

    private Double price;

    private Integer stock;

    private Integer version;

    private String note;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static void main(String[] args) {
        System.out.println(0%2);
        System.out.println(1%2);
        System.out.println(2%2);
    }
}
