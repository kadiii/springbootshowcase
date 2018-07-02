package com.tmaciejewski.showcaseapp.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    
    @Bean
    public MapperFacade mapper() {   
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper;
    }
}
