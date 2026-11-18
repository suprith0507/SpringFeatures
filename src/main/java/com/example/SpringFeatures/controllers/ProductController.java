package com.example.SpringFeatures.controllers;

import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.entities.ProductJPAAuditing;
import com.example.SpringFeatures.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/productAPI")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final  EntityManager entityManager;
    public ProductController(ProductService productService, ModelMapper modelMap , EntityManager entityManager)
    {
        this.productService=productService;
        this.modelMapper=modelMap;
        this.entityManager=entityManager;
    }

    @GetMapping(path="/getProductbyID/{Id}")
    public ResponseEntity<ProductDTO> getProductsList(@PathVariable  @Valid Long Id){

        return    new ResponseEntity<>(productService.getProductById(Id),HttpStatus.OK) ;

    }

    @PostMapping(path="/createProduct")
    public ResponseEntity<ProductDTO> createProductsList(@RequestBody  @Valid ProductDTO input){

        return    new ResponseEntity<>(productService.saveProduct(input),HttpStatus.OK) ;

    }

        @PutMapping(path="/updateProduct/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody  @Valid ProductDTO input , @PathVariable Long productId) {

        return    new ResponseEntity<>(productService.updateProduct(input,productId),HttpStatus.OK) ;

    }
    @GetMapping(path="getProductChanges/{productId}")
    public List<ProductJPAAuditing> getProductHistory( @PathVariable Long productId){

        AuditReader auditReader =
                AuditReaderFactory.get(entityManager);
        List<Number> revisions =
                auditReader.getRevisions(
                        ProductJPAAuditing.class,
                        productId
                );
         return revisions.stream().map(revisionnumber ->auditReader.find(ProductJPAAuditing.class,productId,revisionnumber)).collect(Collectors.toList());

    }

}
