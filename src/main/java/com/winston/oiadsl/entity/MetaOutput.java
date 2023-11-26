package com.winston.oiadsl.entity;

import com.winston.oiadsl.constant.MetaDataFormatEnum;
import com.winston.oiadsl.constant.MetaDataTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MetaOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private MetaDataTypeEnum dataType;
    private Boolean required;
    private String defaultValue;
    private String description;
    private String example;
    private MetaDataFormatEnum dataFormat;

}
