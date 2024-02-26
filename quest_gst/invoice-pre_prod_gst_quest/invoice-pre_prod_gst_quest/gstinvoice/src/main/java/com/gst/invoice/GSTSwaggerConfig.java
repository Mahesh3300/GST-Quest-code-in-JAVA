package com.gst.invoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Data
@ConfigurationProperties(prefix = "swagger")
public class GSTSwaggerConfig  {
	
	private String swaggerHostname;
	
	
	@SuppressWarnings("deprecation")
	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}
	
	
	
	
    @Bean
    public Docket api() {
         
    	Contact contact = new Contact(
                "Siva Prasad",
                "", 
                "siva.prasad@enquero.com"
        );
        
        @SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();
        
        ApiInfo apiInfo = new ApiInfo(
       "Leap RESTful Web Service documentation for Authorization", 
       "This pages documents Leap Authentication and authorization endpoints", "2.0",
       "", contact, 
       "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",vendorExtensions);
    	
        return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(
                Arrays.asList(new ParameterBuilder()
                        .name("accept")
                        .description("Result Type: JSON(application/json)-XML(application/xml)")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(true)
                        .build()))
        				.host(swaggerHostname)
        				.select()
                		.apis(RequestHandlerSelectors.basePackage("com.gst.invoice"))
                		.paths(PathSelectors.any())
                		.build()
                		.apiInfo(apiInfo)
                		;
    }
	
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
      }

      private List<SecurityReference> defaultAuth() {
        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
      }

      private ApiKey apiKey() {
        return new ApiKey("Bearer", "Authorization", "header");
      }
	
}
