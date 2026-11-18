package com.example.SpringFeatures.utilities;


import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.entities.ProductEntity;
import com.example.SpringFeatures.entities.ProductJPAAuditing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructUtility {
    ProductDTO toDTO(ProductEntity productEntity);
    ProductEntity toEntity(ProductDTO productDTO);

    ProductDTO toDTO(ProductJPAAuditing productEntity);
    ProductJPAAuditing toJPAAuditingEntity(ProductDTO productDTO);

}
