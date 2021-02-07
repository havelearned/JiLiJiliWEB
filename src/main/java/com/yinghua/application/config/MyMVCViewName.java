package com.yinghua.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyMVCViewName
 * @Description 自定义视图
 * @Author Luojiaju
 * @crete 2020-12-13-17:17-24
 * @Version 1.0
 */

@Configuration
public class MyMVCViewName implements WebMvcConfigurer {

    /**
     * @return
     * @description: 访问 index.html 跳转到 login 视图
     * @params
     * @data 2020/12/13 17:19
     * @author Luojiaju
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/index.html").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new RootLoginHandler());
        interceptorRegistration.addPathPatterns("/main.html");
    }
}
