package com.yaren.customer_management.service;


import com.yaren.customer_management.model.Product;
import com.yaren.customer_management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Product create(Product product){
        return productRepository.save(product);

    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found. id="+ id));

    }

    public Product update(Long id, Product updatedProduct){
        Product existing = getById(id);

        existing.setName(updatedProduct.getName());
        existing.setUnitPrice(updatedProduct.getUnitPrice());

        return productRepository.save(existing);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
