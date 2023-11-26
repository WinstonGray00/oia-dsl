package com.winston.prddsl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "metaEntity")
    private List<MetaProperty> properties;
    @OneToMany(mappedBy = "metaEntity")
    private List<MetaActivity> activities;
    @OneToMany(mappedBy = "metaEntity")
    private List<MetaRelationship> relationships;

}
