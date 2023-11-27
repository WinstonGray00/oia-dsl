package com.winston.oiadsl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MetaActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<MetaInput> inputs;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<MetaOutput> optionalOutputs;

    @ManyToOne
    private MetaEntity entity;

}
