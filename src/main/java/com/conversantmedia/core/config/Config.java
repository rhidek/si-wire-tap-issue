package com.conversantmedia.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

@ImportResource(locations = {"classpath:spring/integration.xml"})
@Configuration
public class Config {

    @Bean
    public Jackson2JsonObjectMapper jackson2JsonObjectMapper(ObjectMapper objectMapper) {
        return new Jackson2JsonObjectMapper(objectMapper);
    }
}