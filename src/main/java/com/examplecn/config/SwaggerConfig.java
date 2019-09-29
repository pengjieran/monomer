///*
//package com.examplecn.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.TagsSorter;
//import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger.web.UiConfigurationBuilder;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .forCodeGeneration(true)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Bean
//    public UiConfiguration uiConfiguration() {
//
//        return UiConfigurationBuilder.builder()
//                            .deepLinking(true)
//                            .defaultModelExpandDepth(1)
//                            .validatorUrl("")
//                            .displayOperationId(true)
//                            .displayRequestDuration(true)
//                            .tagsSorter(TagsSorter.of("release"))
//                            .showExtensions(true)
//                            .build();
//
//    }
//
//    private ApiInfo apiInfo() {
//
//        return new ApiInfoBuilder()
//                .title("接口列表")
//                .description("RESTful API")
//                .termsOfServiceUrl("http://localhost:8080")
//                .contact(new Contact("Aaron", "https://pengjieran.github.io", "jieran.peng@gmail.com"))
//                .version("1.0")
//                .build();
//    }
//}*/
