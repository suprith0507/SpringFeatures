package com.example.SpringFeatures.repositories;

import com.example.SpringFeatures.entities.ProductJPAAuditing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPAAuditingRepository extends JpaRepository<ProductJPAAuditing, Long> {
}