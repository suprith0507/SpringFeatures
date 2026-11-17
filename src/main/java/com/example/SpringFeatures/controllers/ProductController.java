package com.example.SpringFeatures.controllers;

import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.services.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/productAPI")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMap)
    {
        this.productService=productService;
        this.modelMapper=modelMap;
    }

    @GetMapping(path="/getProductbyID{Id}")
    public ResponseEntity<ProductDTO> getProductsList(@PathVariable  @Valid Long Id){

        return  new ResponseEntity<>(productService.getProductById(Id), HttpStatus.NOT_FOUND) ;

    }
}
