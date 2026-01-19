package com.yaren.customer_management.controller;

import com.yaren.customer_management.model.Product;
import com.yaren.customer_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product updatedProduct(@PathVariable Long id,@RequestBody Product updated){
        return productService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }
}
