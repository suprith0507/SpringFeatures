package com.example.SpringFeatures.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericProjectBeanUtility {

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
}
