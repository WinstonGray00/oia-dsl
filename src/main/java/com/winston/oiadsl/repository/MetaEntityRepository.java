package com.winston.oiadsl.repository;

import com.winston.oiadsl.entity.MetaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface MetaEntityRepository extends ListCrudRepository<MetaEntity, Long> {

    MetaEntity findByName(String name);
}
