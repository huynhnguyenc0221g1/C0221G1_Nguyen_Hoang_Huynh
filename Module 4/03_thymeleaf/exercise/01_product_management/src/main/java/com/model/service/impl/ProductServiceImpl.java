package com.model.service.impl;

import com.model.bean.Product;
import com.model.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone", "High-end Smartphone", "Apple", 1000));
        products.put(2, new Product(2, "Galaxy Fold 2", "Fold-able Phone", "Samsung", 1500));
        products.put(3, new Product(3, "Find X", "Selfie Phone", "Oppo", 700));
        products.put(4, new Product(4, "Zenphone 5", "Mid-tier Phone", "Asus", 400));
        products.put(5, new Product(5, "Vsmart 21 ", "Cheap Smartphone", "Vin Group", 200));
        products.put(6, new Product(6, "Flex ", "High Quality Screen", "LG", 1200));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        name=name.toLowerCase();
        List<Product> productList = new ArrayList<>();
        List<Product> list = findAll();
        for (Product product : list) {
            if (product.getName().toLowerCase().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}