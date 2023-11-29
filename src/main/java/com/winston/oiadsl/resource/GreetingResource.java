package com.winston.oiadsl.resource;


import com.winston.oiadsl.entity.Greeting;
import com.winston.oiadsl.entity.MetaEntity;
import com.winston.oiadsl.example.EntityExample;
import com.winston.oiadsl.repository.GreetingRepository;
import com.winston.oiadsl.repository.MetaEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingResource {

    @Resource
    private GreetingRepository greetingRepository;

    @Resource
    EntityExample entityExample;
    @Resource
    MetaEntityRepository metaEntityRepository;

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

    @GetMapping("/test")
    Greeting test() {
        MetaEntity product = entityExample.generateProduct(null);
        metaEntityRepository.save(product);
        MetaEntity orderItem = entityExample.generateOrderItem(new ArrayList<>() {{
            add(product);
        }});
        metaEntityRepository.save(orderItem);
        MetaEntity order = entityExample.generateOrder(new ArrayList<>() {{
            add(orderItem);
        }});
        metaEntityRepository.save(order);

        return null;
    }

    @GetMapping("/entity")
    List<MetaEntity> getEntity() {
        List<MetaEntity> entities = metaEntityRepository.findAll();

        return entities;
    }

}
