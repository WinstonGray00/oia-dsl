package com.winston.oiadsl.resource;


import com.winston.oiadsl.entity.Greeting;
import com.winston.oiadsl.repository.GreetingRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
