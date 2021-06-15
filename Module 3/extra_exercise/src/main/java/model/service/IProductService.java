package model.service;

import model.bean.Category;
import model.bean.Product;

import java.util.List;

public interface IProductService {
    public void insertProduct(Product product);
    public Product selectProduct(int id);
    public List<Product> selectAllProduct();
    public boolean deleteProduct(int id);
    public boolean updateProduct(Product product);
    public List<Product> findByName(String name);
    public List<Category> selectAllCategories();
}
