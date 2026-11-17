package com.example.SpringFeatures.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_entity_hooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntityHooks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    private String productName;

    private String category;

    private Double price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    //case1
    //if you want to use hibernate managed timestamps
    //use @creationtimestmap @updatiomtimestamp. they do the the same job

    //case2
    //if you want to track the user who did the changes then use
    // @CreatedDate @LastModifiedDate
    // @CreatedBy @LastModifiedBy  along with JPAAuditing

    //case3 use the below life hook methods to implement the same your own way

    /*
     * Executed BEFORE INSERT
     */
    @PrePersist
    public void beforeInsert() {

        System.out.println("========== @PrePersist ==========");
        System.out.println("About to insert entity");

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /*
     * Executed AFTER INSERT
     */
    @PostPersist
    public void afterInsert() {

        System.out.println("========== @PostPersist ==========");
        System.out.println("Insert completed");
        System.out.println("Generated Product ID = " + productId);
    }

    /*
     * Executed AFTER SELECT
     */
    @PostLoad
    public void afterLoad() {

        System.out.println("========== @PostLoad ==========");
        System.out.println("Entity loaded from database");
        System.out.println("Product Name = " + productName);
    }

    /*
     * Executed BEFORE UPDATE
     */
    @PreUpdate
    public void beforeUpdate() {

        System.out.println("========== @PreUpdate ==========");
        System.out.println("About to update entity");

        this.updatedAt = LocalDateTime.now();
    }

    /*
     * Executed AFTER UPDATE
     */
    @PostUpdate
    public void afterUpdate() {

        System.out.println("========== @PostUpdate ==========");
        System.out.println("Update completed");
    }

    /*
     * Executed BEFORE DELETE
     */
    @PreRemove
    public void beforeDelete() {

        System.out.println("========== @PreRemove ==========");
        System.out.println("About to delete entity");
        System.out.println("Product ID = " + productId);
        System.out.println("Product Name = " + productName);

        /*
         * Common real-world usages:
         * Validate deletion
         * Prevent delete if business rule fails
         * Audit logging
         * Soft delete preparation
         */
    }

    /*
     * Executed AFTER DELETE
     */
    @PostRemove
    public void afterDelete() {

        System.out.println("========== @PostRemove ==========");
        System.out.println("Delete completed successfully");
    }
}