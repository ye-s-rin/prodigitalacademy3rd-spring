package com.example.demo.product;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private String name;
    private int price;

    Product(){}

    Product(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
