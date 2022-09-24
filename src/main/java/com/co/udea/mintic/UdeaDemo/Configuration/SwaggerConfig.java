package com.co.udea.mintic.UdeaDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/");
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Api de prueba clase mintic",
                "Ejemplo metodos HTTP",
                "API V 0.0.1",
                "Politicas de uso",
                new Contact("Grupo 15-16", "www.Grupo15-16.com", "noreply@gmail.com"),
                "Licencia libre academica", "API licences URL", Collections.emptyList());
    }
}