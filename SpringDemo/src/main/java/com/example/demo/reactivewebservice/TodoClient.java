package com.example.reactivewebservice;

import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TodoClient {

	private final WebClient client;

	// Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
	// We can use it to create a dedicated `WebClient` for our component.
	public TodoClient(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:8080").build();
	}

	public Mono<String[]> getTasks() {
		return this.client.get().uri("/todos").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Todo.class)
				.map(Todo::getTasks);
	}

}
