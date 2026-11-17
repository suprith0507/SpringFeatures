package com.example.SpringFeatures.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Product_Params" )
public class ProductAttributesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long paramID;

    private String paramName;

    private String paramValue;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private ProductEntity productEntityFK;
//added123

}
