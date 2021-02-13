package com.yinghua.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    Contact contact = new Contact("开发人员A", "http://jilijili.fun", "191865273@qq.com");

    @Bean
    public Docket Docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("开发人员A")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yinghua.application.controller.model"))
                .build();
    }

    @Bean
    public Docket Docket2() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("开发人员B")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("com.yinghua.application.controller"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "肌哩肌哩项目API",
                "Api 用于与android 协调使用",
                "1.2 版本",
                "无 组织",
                contact,
                "Apache 2.0 开源版本号",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());


    }
}
