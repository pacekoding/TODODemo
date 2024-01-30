package com.example.reactivewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class ReactiveWebServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReactiveWebServiceApplication.class, args);
        TodoClient todoClient = context.getBean(TodoClient.class);
        todoClient.getTasks().subscribe(tasks -> {
            System.out.println(">> tasks = " + tasks);
        });
    }

    // @Bean
    // public CorsWebFilter corsWebFilter() {
    //     CorsConfiguration corsConfig = new CorsConfiguration();
    //     corsConfig.setAllowedOrigins("*"); // Set your allowed origins here
    //     corsConfig.addAllowedMethod(HttpMethod.GET);
    //     corsConfig.addAllowedMethod(HttpMethod.POST);

    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", corsConfig);

    //     return new CorsWebFilter(source);
    // }
}
