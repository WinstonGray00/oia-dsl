package com.winston.oiadsl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.winston.oiadsl.constant.MetaDataFormatEnum;
import com.winston.oiadsl.constant.MetaDataTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "entity_id"})
})
public class MetaProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    private MetaDataTypeEnum dataType;
    // TODO Not supported yet
    private MetaDataFormatEnum dataFormat;

    private Boolean isRequired;
    private Boolean isUnique;

    private String defaultValue;
    private String example;

    @ManyToOne // TODO when circular references occurs, should add @JsonIgnore to prevent infinite loop
    private MetaEntity referencedEntity;

    @ManyToOne
    @JsonIgnore
    private MetaEntity entity;


//    @OneToOne(mappedBy = "referencedProperty")
//    // TODO think about this if it is needed
//    private MetaData data;

    @Override
    public String toString() {
        return "MetaProperty{" +
                "id=" + id +
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
