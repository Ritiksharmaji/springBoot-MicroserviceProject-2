package com.scaler1.scalerProject_1.repositories;

import com.scaler1.scalerProject_1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
