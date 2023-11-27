package com.winston.oiadsl;

import com.winston.oiadsl.entity.MetaEntity;
import com.winston.oiadsl.example.EntityExample;
import com.winston.oiadsl.repository.EntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OiadslApplication {

    public static void main(String[] args) {
        SpringApplication.run(OiadslApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EntityRepository repository) {
        return args -> {
            EntityExample entityExample = new EntityExample();
            MetaEntity order = entityExample.generateOrder();
            MetaEntity orderItem = entityExample.generateOrderItem();
            MetaEntity product = entityExample.generateProduct();

            repository.save(order);
            repository.save(orderItem);
            repository.save(product);
        };
    }

}
