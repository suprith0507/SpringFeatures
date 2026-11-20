package com.example.SpringFeatures.utilities;

import com.example.SpringFeatures.Authentications.AuditorAwareImpl;
import com.example.SpringFeatures.dtos.ProductDTO;
import com.example.SpringFeatures.entities.ProductEntity;
import com.example.SpringFeatures.entities.ProductJPAAuditing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@EnableJpaAuditing  //this is the switch to turn on JPAAuditing
public class GenericProjectBeanUtility {
    @Value("${employeeservice.base.url}")
    private  String BASE_URL;
    @Bean
    public ModelMapper getModelMapperBean()
    {
        return new ModelMapper();
        // we cant directly autowire builtin classes.we can autowire components
        //we cant create our own component class for ModelMapper
        //This one tells spring to create beans for ModelMapper and then we can autowire
        //when spring looks for Autowired annotation of ModelMapper, it will not create a bean it will give from here.
        //we need to use this approach to inject utility beans and should not use new ModelMapper() anywhere in the code. it is not the spring way of doing things
    }

    @Bean
    public AuditorAware<String> getAuditorAware()
    {
        return new AuditorAwareImpl();
    }

    @Bean
     public RestClient getRestClientBean(){
        return RestClient.builder().
                baseUrl(BASE_URL).
                defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE).
                defaultStatusHandler(HttpStatusCode::is5xxServerError,(req,res)->{
                    System.out.println("Status = " + res.getStatusCode());
                    throw new RuntimeException("Server Error Occured");
                }).
                build();
    }

}
