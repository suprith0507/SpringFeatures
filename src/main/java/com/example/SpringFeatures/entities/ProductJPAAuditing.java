package com.example.SpringFeatures.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name="Product_JPAAuditing")
public class ProductJPAAuditing  extends AuditableBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(name="Product_Name",nullable = false)
    private String name;

    @Column(name="Category_Name",nullable = false)
    @NotAudited
    private String category;


    private String secretBarcode;
}
