package com.yi_blog.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/admin","/admin/*","/write");
        registration.excludePathPatterns("/index",
                "/",
                "/archive",
                "/article",
                "/css/*",
                "/js/*",
                "/images/*",
                "/fonts/*",
                "/layui/*",
                "/lib/*",
                "/lib/codemirror/*");
    }
}
