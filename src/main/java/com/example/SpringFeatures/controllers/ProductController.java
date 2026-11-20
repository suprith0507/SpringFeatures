package com.example.SpringFeatures.controllers;

import com.example.SpringFeatures.APIBeans.GenericAPIResponse;
import com.example.SpringFeatures.dtos.EmployeeDTO;
import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.entities.ProductJPAAuditing;
import com.example.SpringFeatures.exceptions.CustomResourceNotFoundException;
import com.example.SpringFeatures.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/productAPI")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final  EntityManager entityManager;
    private final RestClient restClient;
    public ProductController(ProductService productService, ModelMapper modelMap , EntityManager entityManager, RestClient restClient)
    {
        this.productService=productService;
        this.modelMapper=modelMap;
        this.entityManager=entityManager;
        this.restClient=restClient;
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

    @GetMapping(path="/getRemoteEmployees")
    public GenericAPIResponse<List<EmployeeDTO>> getAllEmployeesThroughRestClient()
    {
        GenericAPIResponse<List<EmployeeDTO>> employeeDTOList =restClient.get().
                                      uri("/getAllEmployees").
                                      retrieve().
                                      onStatus(HttpStatusCode::is4xxClientError,(req,resp)->{ throw new CustomResourceNotFoundException("Boss Remote server didnt find the data requested");
                                      }) .
                                      body( new ParameterizedTypeReference<>(){});
        return employeeDTOList;
    }

    @GetMapping(path="/getRemoteEmployeeById")
    public GenericAPIResponse<EmployeeDTO> getEmployeebyIdThroughRestClient( Long eID)
    {

        logger.error("info {} {}",eID,eID);
        logger.warn("info {} {}",eID,eID);
        logger.info("info {} {}",eID,eID);
        logger.debug("info {} {}",eID,eID);
        logger.trace("info {} {}",eID,eID);

        var employeeDTO =restClient.get().
                uri("/getEmployeeByID/{EmployeeID}",eID).
                retrieve().
                onStatus(HttpStatusCode::is4xxClientError,(req,resp)->{ throw new CustomResourceNotFoundException("Boss Remote server didnt find the data requested");
                }) .
                body( new ParameterizedTypeReference<>(){});
        return  new GenericAPIResponse(employeeDTO);
    }
    @PostMapping(path="/createRemoteEmployee")
    public ResponseEntity<EmployeeDTO> createEmployeeThroughRestClient(@RequestBody EmployeeDTO employeeDTO)
    {
        ResponseEntity<EmployeeDTO> employeeDTO1 =restClient.post().
                uri("/saveEmployee").
                body(employeeDTO).
                retrieve().
                onStatus(HttpStatusCode::is4xxClientError,(req,resp)->{
                    System.out.println("Status = " + resp.getStatusCode());
                    throw new CustomResourceNotFoundException("Boss Remote server didnt find the data requested");
                }) .
                //body( new ParameterizedTypeReference<>(){});
                toEntity(EmployeeDTO.class); //we can use like this also and return response entity
        //return  new GenericAPIResponse(employeeDTO1);
        return employeeDTO1;
    }

}
