package com.example.onlineshop.service;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.model.Product;
import com.example.onlineshop.repository.CategoryRepository;
import com.example.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Integer getTotalItems() {
        return productRepository.findAll().stream()
                .mapToInt(Product::getTotalItems).sum();
    }

    public Double getTotalValue() {
        return productRepository.findAll().stream()
                .mapToDouble(p -> p.getProductPrice() * p.getTotalItems()).sum();
    }

    public Integer getTotalProducts() {
        return (int) productRepository.count();
    }

    // ✅ Save (for Add or Update)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // ✅ Delete by ID
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
