package com.example.SpringFeatures.services;

import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.entities.ProductEntity;
import com.example.SpringFeatures.exceptions.CustomResourceNotFoundException;
import com.example.SpringFeatures.repositories.ProductEntityRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;
    public ProductService(ProductEntityRepository productEntityRepository, ModelMapper modelmap) {
        this.productEntityRepository=productEntityRepository;
        this.modelMapper=modelmap;
    }

    public ProductDTO getProductById(Long productId)
    {
            ProductEntity productEntity= productEntityRepository.findById(productId).orElseThrow(() ->  new CustomResourceNotFoundException("Id not found Boss"));
            return modelMapper.map(productEntity , ProductDTO.class);
            //notesddsds

    }
}
