package com.tutorial.boot.service;


import com.tutorial.boot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getProductList() {
        Product p1 = new Product("gray", "t-shirt", 5000);
        Product p2 = new Product("black", "coffee", 700);
        Product p3 = new Product("blue", "jam", 2500);
        Product p4 = new Product("red", "pen", 1500);

        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        return products;
    }
}
