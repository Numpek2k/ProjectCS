package com.example.hotdoctors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HotDoctorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotDoctorsApplication.class, args);
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Configuration
//    public static class WebMvcConfig implements WebMvcConfigurer{
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/*")
//                    .allowedOrigins("*")
//                    .allowedMethods("*")
//                    .allowedHeaders("*")
//                    .maxAge(-1)
//                    .allowCredentials(true);
//        }
//    }

    @Bean
    public WebMvcConfigurer CORSConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                        .maxAge(-1);
            }
        };
    }
}
