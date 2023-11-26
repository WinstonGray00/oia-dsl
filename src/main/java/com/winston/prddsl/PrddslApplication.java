package com.winston.prddsl;

import com.winston.prddsl.entity.Greeting;
import com.winston.prddsl.repository.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class PrddslApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrddslApplication.class, args);
    }

}
