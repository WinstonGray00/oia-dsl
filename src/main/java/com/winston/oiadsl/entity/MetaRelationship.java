package com.winston.oiadsl.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MetaRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    @ManyToOne
    private MetaEntity from;
    @ManyToOne
    private MetaEntity to;

}
