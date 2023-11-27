package com.winston.oiadsl.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MetaOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private MetaData data;

}
