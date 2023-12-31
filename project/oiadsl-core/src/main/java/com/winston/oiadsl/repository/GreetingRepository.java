package com.winston.oiadsl.repository;

import com.winston.oiadsl.entity.Greeting;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface GreetingRepository extends Repository<Greeting, Long> {

    Greeting save(Greeting greeting);

    Optional<Greeting> findById(Long id);

    void deleteById(Long id);

    void delete(Greeting greeting);


}
