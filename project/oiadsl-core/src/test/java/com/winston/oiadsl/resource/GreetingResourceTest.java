package com.winston.oiadsl.resource;

import com.winston.oiadsl.entity.Greeting;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class GreetingResourceTest {

    @Resource
    private GreetingResource greetingResource;

    @Test
    void testHello() {
        Greeting greeting = greetingResource.hello("1");
        System.out.println(greeting);
    }

    @Test
    void testHelloAdd() {
        Greeting greeting = new Greeting(null,
                "Hello, World!", LocalDateTime.now(), "Winston's house");

        greetingResource.helloAdd(greeting);
    }

}