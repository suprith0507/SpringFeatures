package com.example.SpringFeatures.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductJPAAuditing  extends AuditableBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(name="Product_Name",nullable = false)
    private String name;

    @Column(name="Category_Name",nullable = false)
    private String category;

    private String secretBarcode;
}
