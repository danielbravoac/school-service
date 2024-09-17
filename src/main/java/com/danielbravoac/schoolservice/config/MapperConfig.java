package com.danielbravoac.schoolservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
