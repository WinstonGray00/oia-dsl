package com.winston.prddsl.entity;

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

    @OneToMany(mappedBy = "metaActivity")
    private List<MetaInput> inputs;
    @OneToMany(mappedBy = "metaActivity")
    private List<MetaOutput> outputs;

}
