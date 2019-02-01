package com.jason.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

/**
 * @Author:jason
 * @Description:
 * @Date:2017/11/15
 * @Modified by:
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class Swagger2Config {

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 按条件指定生成文档接口
                .apis(RequestHandlerSelectors.basePackage("com.jason.controller"))// 指定包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Json System Restfull API")
                .description("Json System Restfull API帮助文档")
                .termsOfServiceUrl("http://www.baidu.com/")
                .contact(new Contact("百度","http://www.baidu.com/","jason@126.com"))
                .version("V1.0")
                .build();
    }

}
