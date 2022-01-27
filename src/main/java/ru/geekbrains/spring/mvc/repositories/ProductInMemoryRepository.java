package ru.geekbrains.spring.mvc.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.mvc.model.Product;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductInMemoryRepository implements ProductRepository {
    private Map<Integer, Product> products;

    @PostConstruct
    public void init() {
        products = new HashMap<Integer, Product>();
        products.put(121, new Product(121, "Orange", 7));
        products.put(15, new Product(15, "Spoon", 15));
    }

    @Override
    public void addProduct(Product product) {
        if (product.getId()>0) {
            if (products.get(product.getId()) == null) {
                products.put(product.getId(), product);
            } else {
                throw new IllegalArgumentException("Product is already exist!");
            }
        } else {
            throw new IllegalArgumentException("Product ID is illegal!");
        }
    }

    @Override
    public Product getProduct(Product product) {
        return products.get(product.getId());
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }

    @Override
    public Map<Integer, Product> getAll() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public void updateProduct(Product product) {
        if (products.get(product.getId()) != null) {
            products.put(product.getId(), product);
        } else {
            throw new IllegalArgumentException("There is no such product!");
        }
    }

    @Override
    public void deleteProduct(Product product) {
        if (products.get(product.getId()) != null) {
            products.remove(product.getId());
        } else {
            throw new IllegalArgumentException("There is no such product!");
        }
    }

    @Override
    public void deleteProductById(int id) {
        if (products.get(id) != null) {
            products.remove(id);
        } else {
            throw new IllegalArgumentException("There is no such product!");
        }
    }

    @Override
    public boolean isExist(int id) {
        if (products.get(id)!=null) {
            return true;
        }
        return false;
    }
}
