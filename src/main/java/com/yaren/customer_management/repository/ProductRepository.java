package com.yaren.customer_management.repository;

import com.yaren.customer_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
