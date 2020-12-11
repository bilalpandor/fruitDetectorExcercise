package io.fruitdetector.controller;

import io.fruitdetector.client.FruitDetectorClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class FruitDetectorController {

    private FruitDetectorClient fruitDetectorClient;

    @GetMapping(path = "/detectFakeFruit", produces = TEXT_PLAIN_VALUE)
    @ResponseBody
    public Mono<String> getFakeWithList(@RequestParam List<String> fruits) {
        fruitDetectorClient = new FruitDetectorClient();
        return this.fruitDetectorClient.detectFake(fruits);
    }

    @GetMapping(path = "/detectFakeFruitFromDefaultList", produces = TEXT_PLAIN_VALUE)
    @ResponseBody
    public Mono<String> getFake() {
        fruitDetectorClient = new FruitDetectorClient();
        List<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("pair");
        return this.fruitDetectorClient.detectFake(fruits);
    }

}
