package com.scaler1.scalerProject_1.repositories;

import com.scaler1.scalerProject_1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
