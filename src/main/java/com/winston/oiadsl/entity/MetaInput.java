package com.winston.oiadsl.entity;

import com.winston.oiadsl.constant.MetaDataFormatEnum;
import com.winston.oiadsl.constant.MetaDataTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MetaInput {
    @Id
    private Long id;

    private String name;
    private MetaDataTypeEnum dataType;
    private Boolean isRequired;
    private String defaultValue;
    private String description;
    private String example;
    private MetaDataFormatEnum dataFormat;


}
