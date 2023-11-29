package com.winston.oiadsl.repository;

import com.winston.oiadsl.entity.MetaEntity;
import com.winston.oiadsl.entity.MetaProperty;
import org.springframework.data.repository.CrudRepository;

public interface MetaPropertyRepository extends CrudRepository<MetaProperty, Long> {

    MetaProperty findByName(String code);

    MetaProperty findByNameAndEntity(String code, MetaEntity entity);
}
