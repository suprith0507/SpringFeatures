package com.example.SpringFeatures.services;

import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.entities.ProductEntity;
import com.example.SpringFeatures.entities.ProductJPAAuditing;
import com.example.SpringFeatures.exceptions.CustomResourceNotFoundException;
import com.example.SpringFeatures.repositories.ProductEntityRepository;
import com.example.SpringFeatures.repositories.ProductJPAAuditingRepository;
import com.example.SpringFeatures.utilities.MapStructUtility;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductEntityRepository productEntityRepository;
    private final ProductJPAAuditingRepository productJPAAuditingRepository;
    private final ModelMapper modelMapper;
    private final MapStructUtility mapStructUtility;
    public ProductService(ProductEntityRepository productEntityRepositor, ModelMapper modelmap, ProductJPAAuditingRepository productJPAAuditingRepositor,MapStructUtility mapStructUtility) {
        this.productEntityRepository=productEntityRepositor;
        this.modelMapper=modelmap;
        this.productJPAAuditingRepository=productJPAAuditingRepositor;
        this.mapStructUtility=mapStructUtility;
    }

    public ProductDTO getProductById(Long productId)
    {
            ProductEntity productEntity= productEntityRepository.findById(productId).orElseThrow(() ->  new CustomResourceNotFoundException("Id not found Boss"));
            return modelMapper.map(productEntity , ProductDTO.class);
            //notesddsds

    }

    public ProductDTO saveProduct( ProductDTO input) {

        ProductJPAAuditing productEntityinput= mapStructUtility.toJPAAuditingEntity(input);
        ProductJPAAuditing productEntity =productJPAAuditingRepository.save(productEntityinput);
        return modelMapper.map(productEntity, ProductDTO.class);

    }

    public ProductDTO updateProduct( ProductDTO input ,Long productId) {

        ProductJPAAuditing productEntityinput=productJPAAuditingRepository.findById(productId).orElseThrow(()->new CustomResourceNotFoundException("Product not found from update method"));
        input.setProductId(productId);
        modelMapper.map(input,productEntityinput);
        ProductJPAAuditing updatedproductEntity =productJPAAuditingRepository.save(productEntityinput);
        return modelMapper.map(updatedproductEntity, ProductDTO.class);
    }
}
