package com.winston.prddsl.resource;


import com.winston.prddsl.entity.Greeting;
import com.winston.prddsl.repository.GreetingRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class GreetingResource {

    @Resource
    private GreetingRepository greetingRepository;

    @GetMapping("/hello/{id}")
    Greeting hello(@PathVariable("id") String id) {
        return greetingRepository.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/hello")
    Greeting helloAdd(@RequestBody Greeting greeting) {
//        Greeting greeting = new Greeting(null,
//                "Hello, World!", LocalDateTime.now(), "Winston's house");

        greetingRepository.save(greeting);

        return greeting;
    }

}
