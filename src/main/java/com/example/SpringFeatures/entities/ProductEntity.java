package com.example.SpringFeatures.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @OneToMany(mappedBy = "productIdFK",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private ProductAttributesEntity productAttributes;



}
