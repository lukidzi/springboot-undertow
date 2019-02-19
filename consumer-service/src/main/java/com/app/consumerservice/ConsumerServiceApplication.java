package com.app.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    @RestController
    class ExampleEndpoint {

        private final WebClient webClient;

        public ExampleEndpoint() {
            this.webClient = WebClient.builder().build();
        }

        @GetMapping(value = "/consume")
        Mono<String> consumeData() {
            return webClient
                    .get()
                    .uri("http://localhost:8081/data")
                    .exchange()
                    .flatMap(clientResponse -> clientResponse.bodyToMono(String.class));
        }
    }

}
