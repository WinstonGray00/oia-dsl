package com.winston.oiadsl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code", "data_id"})
})
public class MetaOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private MetaData data;

}
