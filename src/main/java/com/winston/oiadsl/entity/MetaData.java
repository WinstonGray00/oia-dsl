package com.winston.oiadsl.entity;

import com.winston.oiadsl.constant.MetaDataFormatEnum;
import com.winston.oiadsl.constant.MetaDataTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isArray;

    private String name;
    private String description;

    private MetaDataTypeEnum dataType;
    // TODO Not supported yet
    private MetaDataFormatEnum dataFormat;

    private Boolean isRequired;
    private Boolean isUnique;

    private String defaultValue;
    private String example;

    /**
     * Recursive relationship.
     */
    @OneToOne
    private MetaData parent;

    /**
     * Some of the output data are properties of an entity.
     * Establishing a reference relationship here is more in line with understanding habits.
     */
    @OneToOne
    private MetaProperty referencedProperty;

    @Transient
    private List<MetaData> children;

}
