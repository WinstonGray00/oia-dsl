package com.winston.prddsl.entity;

import com.winston.prddsl.constant.MetaDataFormatEnum;
import com.winston.prddsl.constant.MetaDataTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MetaInput {
    @Id
    private Long id;

    private String name;
    private MetaDataTypeEnum dataType;
    private Boolean required;
    private String defaultValue;
    private String description;
    private String example;
    private MetaDataFormatEnum dataFormat;

    @ManyToOne
    private MetaActivity metaActivity;
}
