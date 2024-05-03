package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String hello() {
        return this.productRepository.hello().getName();
    }

    public String hi() {
        return this.productRepository.hi().getName();
    }

    public ArrayList findProducts() {
        return this.productRepository.findProducts();
    }

    public String findProductName(Integer id) {
        return this.productRepository.findProductName(id).getName();
    }

    public void save(String productInfo) {
        this.productRepository.save(new Product(productInfo));
    }

    public HashMap pagination(int page, int offset) {
        return this.productRepository.pagination(page, offset);
    }
}
