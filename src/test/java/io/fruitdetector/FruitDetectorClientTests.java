package io.fruitdetector;

import io.fruitdetector.client.FruitDetectorClient;
import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

public class FruitDetectorClientTests {

    private FruitDetectorClient fruitDetectorHandler;
    private List<String> fruits;

    @Test
    public void detectZeroFakeFruits(){
        fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("pear");

        fruitDetectorHandler = new FruitDetectorClient();

        Mono<String> result = fruitDetectorHandler.detectFake(fruits);

        StepVerifier.create(result)
                    .verifyComplete();
    }

    @Test
    public void detectOneFakeFruit(){
        fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("pair");

        fruitDetectorHandler = new FruitDetectorClient();
        Mono<String> result = fruitDetectorHandler.detectFake(fruits);

        StepVerifier.create(result)
                    .assertNext(s-> Assert.assertSame(s, "pair"))
                    .verifyComplete();
    }
}
