package com.example.crudswagger.config;


import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        import springfox.documentation.builders.ApiInfoBuilder;
        import springfox.documentation.builders.PathSelectors;
        import springfox.documentation.builders.RequestHandlerSelectors;
        import springfox.documentation.service.ApiInfo;
        import springfox.documentation.service.Contact;
        import springfox.documentation.spi.DocumentationType;
        import springfox.documentation.spring.web.plugins.Docket;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.crudswagger.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiMetaData());

    }

    private ApiInfo apiMetaData() {
        return new ApiInfoBuilder()

                .title("Alterra API Documentation")
                .description("API Documetation for Alterra Task Generated with Swagger Doc")
                .version("v1.0.0")
                .license("Alterra and IKON")
                .licenseUrl("www.ikonsultan.com")
                .contact(new Contact("M Nu'man Arif H", "numanarif.xyz",
                        "numanarif87@gmail.com"))
                .build();
    }

}