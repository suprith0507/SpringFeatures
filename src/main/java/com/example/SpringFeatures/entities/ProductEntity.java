package com.example.SpringFeatures.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
@Entity
@Table(name="Product_Entity")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(name="Product_Name",nullable = false)
    private String name;

    @Column(name="Category_Name",nullable = false)
    private String category;

    private String secretBarcode;


    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updationTime;

    @OneToMany(mappedBy = "productEntityFK",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ProductAttributesEntity> productAttributes =new ArrayList<>();



}
