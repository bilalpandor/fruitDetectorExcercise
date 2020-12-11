package io.fruitdetector;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FruitDetector {
    private final String fakeFruit = "pair";

    public Mono<String> detectFake(Flux<String> fruits){
        return Mono.justOrEmpty(
                fruits.toStream()
                        .filter(fruit -> fruit.equalsIgnoreCase(fakeFruit))
                        .findFirst()
        );
//        return Mono.justOrEmpty(fruits.filter(fruit -> fruit.equalsIgnoreCase(fakeFruit))));
    }
}
