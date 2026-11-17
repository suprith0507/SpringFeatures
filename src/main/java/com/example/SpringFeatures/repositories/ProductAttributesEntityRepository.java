package com.example.SpringFeatures.repositories;

import com.example.SpringFeatures.entities.ProductAttributesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributesEntityRepository extends JpaRepository<ProductAttributesEntity, Long> {
}