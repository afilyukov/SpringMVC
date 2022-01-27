package ru.geekbrains.spring.mvc.repositories;

import ru.geekbrains.spring.mvc.model.Product;

import java.util.Map;

public interface ProductRepository {
    void addProduct(Product product);
    Product getProductById(int id);
    Product getProduct(Product product);
    boolean isExist(int id);
    Map<Integer, Product> getAll();
    void updateProduct(Product product);
    void deleteProduct(Product product);
    void deleteProductById(int id);
}
