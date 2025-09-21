package com.example.blogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // This will allow CORS for all URLs in your app
        registry.addMapping("/**")
                .allowedOrigins("https://blogger-site-seven.vercel.app/","https://blogger-site-seven.vercel.app","http://192.168.1.10:5173","http://192.168.1.10:5173/","http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow cookies or JWT tokens
    }
}
