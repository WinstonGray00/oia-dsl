package com.winston.oiadsl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
     * Some of the output data are properties of an entity.
     * Establishing a reference relationship here is more in line with understanding habits.
     */
    @ManyToOne
    private MetaProperty referencedProperty;

    /**
     * Recursive relationship.
     */
    @ManyToOne
    @JsonIgnore
    private MetaData parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<MetaData> children;

    @Override
    public String toString() {
        return "MetaData{" +
                "id=" + id +
                ", isArray=" + isArray +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dataType=" + dataType +
                ", dataFormat=" + dataFormat +
                ", isRequired=" + isRequired +
                ", isUnique=" + isUnique +
                ", defaultValue='" + defaultValue + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
