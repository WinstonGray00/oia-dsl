package com.winston.prddsl.entity;

import com.winston.prddsl.constant.MetaDataFormatEnum;
import com.winston.prddsl.constant.MetaDataTypeEnum;
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
    private MetaDataFormatEnum dataFormat;

    private Boolean required;
    private Boolean unique;

    private String defaultValue;
    private String example;

    @ManyToOne
    private MetaEntity metaEntity;

}
