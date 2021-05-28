package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "iPhone", 1000, "High-end", "Apple"));
        productList.put(2, new Product(2, "Samsung", 1500, "Foldable", "South Korea"));
        productList.put(3, new Product(3, "Xiaomi", 600, "Middle class", "China"));
    }


    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }


    public void save(Product product) {
        productList.put(product.getId(), product);
    }


    public Product findById(int id) {
        return productList.get(id);
    }


    public void update(int id, Product product) {
        productList.put(product.getId(), product);
    }


    public void remove(int id) {
        productList.remove(id);
    }

    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        List<Product> products = new ArrayList<>(productList.values());
        for (Product product : products) {
            if ((product.getName().toLowerCase()).equals(name.toLowerCase())) {
                searchList.add(product);
            }
        }

        return searchList;
    }
}
