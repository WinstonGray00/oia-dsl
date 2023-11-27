package com.winston.oiadsl.repository;

import com.winston.oiadsl.entity.MetaEntity;
import org.springframework.data.repository.CrudRepository;

public interface EntityRepository extends CrudRepository<MetaEntity, Long> {

}
