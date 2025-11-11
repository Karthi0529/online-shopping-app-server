package com.example.onlineshop.controller;

import com.example.onlineshop.model.Product;
import com.example.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Get all products
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    // ✅ Get dashboard info
    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardData() {
        Map<String, Object> map = new HashMap<>();
        map.put("totalProducts", productService.getTotalProducts());
        map.put("totalItems", productService.getTotalItems());
        map.put("totalValue", productService.getTotalValue());
        map.put("categories", productService.getAllCategories());
        return map;
    }

    // ✅ Add new product
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // ✅ Update existing product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setProductId(id);
        return productService.saveProduct(product);
    }

    // ✅ Delete product by ID
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
