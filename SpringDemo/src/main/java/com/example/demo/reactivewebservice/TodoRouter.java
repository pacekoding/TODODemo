package com.example.reactivewebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class TodoRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TodoHandler todoHandler) {
        return RouterFunctions
                .route(GET("/todos").and(accept(MediaType.APPLICATION_JSON)), todoHandler::getAllTasks);
    }
}