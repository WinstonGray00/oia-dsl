package com.winston.oiadsl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "entity_id"})
})
public class MetaActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private MetaInput input;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<MetaOutput> optionalOutputs;

    @ManyToOne
    @JsonIgnore
    private MetaEntity entity;

    @Override
    public String toString() {
        return "MetaActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", input=" + input +
                ", optionalOutputs=" + optionalOutputs +
                '}';
    }
}
