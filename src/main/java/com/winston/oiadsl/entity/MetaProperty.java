package com.winston.oiadsl.entity;

import com.winston.oiadsl.constant.MetaDataFormatEnum;
import com.winston.oiadsl.constant.MetaDataTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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

    @ManyToOne
    private MetaEntity referencedEntity;

    @ManyToOne
    private MetaEntity entity;

//    @OneToOne(mappedBy = "referencedProperty")
//    // TODO think about this if it is needed
//    private MetaData data;

}
