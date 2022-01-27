package ru.veles.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.veles.spring.mvc.model.Product;
import ru.veles.spring.mvc.repositories.ProductRepository;

import java.util.List;


@Component
public class ProductService {

    @Autowired
    @Qualifier("productInMemoryRepository")
    private ProductRepository productRepository;

    @Value("12234-42342-234234")
    private String identifier;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id, String title, int cost){
        productRepository.addProduct(new Product(id,title,cost));
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

    public Product getProductById(int id){
       return productRepository.getProductById(id);
    }

    boolean isExist(int id){
        return productRepository.isExist(id);
    }

    public void updateProduct(int id, String title, int cost){
        productRepository.updateProduct(new Product(id, title, cost));
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void deleteProduct(Product product){
        productRepository.deleteProduct(product);
    }

    public void deleteProductById(int id){
        productRepository.deleteProductById(id);
    }

    public int calculateAverageCost() {
        List<Product> products = productRepository.getAll();
        if (products.isEmpty()) { return 0;}
        int avg = 0;
        for (Product p : products) {
            avg += (int)p.getCost();
        }
        avg /= products.size();
        return avg;
    }

    public int getAmountOfProducts() {
        List<Product> products = productRepository.getAll();
        if (products.isEmpty()) { return 0;}
        return products.size();
    }


}
