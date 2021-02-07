package com.yinghua.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


@SpringBootApplication
@MapperScan("com.yinghua.application.mapper") //扫描持久层
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 自定义视图解析器
     */
    @Bean
    public ViewResolver myViewReslver() {
        return new MyViewResolver();
    }

    /**
     * 实现 解析器接口 ViewResolver 容器就会把自定义的解析器加入到 解析列表中
     */
    private static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }


}
