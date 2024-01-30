package com.example.reactivewebservice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TodoHandler {

    public Mono<ServerResponse> getAllTasks(ServerRequest request) {
        Todo todo = new Todo(new String[]{"Makan!", "Makan!", "Makan!"});
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(todo));
    }
}
