package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

    private HashMap<Integer, Product> db = new HashMap<>();

    public ProductRepository() {
        this.db.put(0, new Product("notebook"));
        this.db.put(1, new Product("hello"));
        this.db.put(2, new Product("hi"));
        this.db.put(3, new Product("cup"));
        this.db.put(4, new Product("phone"));
    }

    public Product hello() {
        return this.db.get(1);
    }

    public Product hi() {
        return this.db.get(2);
    }

    public ArrayList findProducts() {
        return new ArrayList<>(db.values());
    }

    public Product findProductName(Integer id) {
        return this.db.get(id);
    }

    public void save(Product product) {
        this.db.put(this.db.size(), product);
    }

    public HashMap pagination(int page, int offset) {
        HashMap result = new HashMap<String, Object>();
        HashMap subProducts = new HashMap<Integer, Product>();
        int lastPage = (int) Math.ceil((double) this.db.size() / offset);

        int currentPage = Math.min(page * offset, lastPage);
        for (int i = currentPage; i < Math.min(currentPage + offset, db.size()); i++) {
            subProducts.put(i, db.get(i));
        }

        result.put("subProducts", subProducts);
        result.put("currentPage", currentPage);
        result.put("lastPage", lastPage);

        return result;
    }
}
