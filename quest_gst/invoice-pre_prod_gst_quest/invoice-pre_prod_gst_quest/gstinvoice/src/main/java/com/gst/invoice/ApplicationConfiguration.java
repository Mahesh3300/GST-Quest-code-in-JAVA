package com.gst.invoice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author smriti
 * THIS CLASS REPRESENTS CONFIGURATION TO PROVIDE PROPERTIES FILES TO SPRING ENVIRONMENT
 */
@Configuration
@PropertySource({"classpath:application.properties"})
public class ApplicationConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}