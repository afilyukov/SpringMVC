package ru.geekbrains.spring.mvc.controllers;

import ru.geekbrains.spring.mvc.model.Product;
import ru.geekbrains.spring.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("frontProducts", productService.getAll().values());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products/all";
    }

}
