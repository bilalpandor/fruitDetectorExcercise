package io.fruitdetector;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class FruitDetectorHandler {

    private final FruitDetector fruitDetector = new FruitDetector();

    public Mono<ServerResponse>  returnFakeFruit(ServerRequest request) {
        return ok()
                .contentType(APPLICATION_STREAM_JSON)
                .body(BodyInserters.fromValue(fruitDetector.detectFake(request.bodyToFlux(String.class))));
    }
}
