package com.winston.oiadsl.entity;

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
    private String description;

    @OneToMany(mappedBy = "entity", cascade = CascadeType.PERSIST)
    private List<MetaProperty> properties;
    @OneToMany(mappedBy = "entity", cascade = CascadeType.PERSIST)
    private List<MetaActivity> activities;

    /**
     * seems no need to define relationships, because the relationship is defined in the meta property
     * TODO remove this property
     */
//    @OneToMany(mappedBy = "metaEntity")
//    private List<MetaRelationship> relationships;

}
