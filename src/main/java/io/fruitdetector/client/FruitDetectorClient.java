package io.fruitdetector.client;

import reactor.core.publisher.Mono;
import java.util.List;

public class FruitDetectorClient {

    private final String fakeFruit = "pair";

    public Mono<String> detectFake(List<String> fruits){
        return Mono.justOrEmpty(
                fruits.stream()
                        .filter(fruit -> fruit.equalsIgnoreCase(fakeFruit))
                        .findFirst()
        );
    }
}
