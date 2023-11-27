package com.winston.oiadsl.example;

import com.winston.oiadsl.constant.MetaDataTypeEnum;
import com.winston.oiadsl.entity.MetaData;
import com.winston.oiadsl.entity.MetaEntity;
import com.winston.oiadsl.entity.MetaProperty;

import java.util.ArrayList;
import java.util.List;

public class MetaDataExample {

    public static MetaData orderProductSuccessful(MetaEntity metaEntity) {
        // output's structure is like this
        // orderProductSuccessful:{result:1,data:{order:{id:1,orderItems[{$oderItem1},{$oderItem2}]}}}

        MetaData root = new MetaData();
        root.setName("orderProductSuccessful");
        root.setDescription("orderProductSuccessful");
        root.setDataType(MetaDataTypeEnum.OBJECT);
        root.setIsArray(false);

        root.setIsRequired(true);
        root.setIsUnique(false);
        root.setDefaultValue("");
        root.setExample("");
        root.setDataFormat(null);
        root.setReferencedProperty(null);

        root.setParent(null);

        // result
        MetaData result = new MetaData();
        result.setName("result");
        result.setDescription("result");
        result.setDataType(MetaDataTypeEnum.NUMBER);
        result.setIsArray(false);

        result.setIsRequired(true);
        result.setIsUnique(false);
        result.setDefaultValue("");
        result.setExample("");
        result.setDataFormat(null);
        result.setReferencedProperty(null);
        result.setParent(root);

        root.setChildren(addChildren(root, result));

        // data
        MetaData data = new MetaData();
        data.setName("data");
        data.setDescription("data");
        data.setDataType(MetaDataTypeEnum.OBJECT);
        data.setIsArray(false);

        data.setIsRequired(true);
        data.setIsUnique(false);
        data.setDefaultValue("");
        data.setExample("");
        data.setDataFormat(null);
        data.setReferencedProperty(null);
        data.setParent(root);

        root.setChildren(addChildren(root, data));

        // order's properties
        buildMetaDataFromEntityPropertiesRecursively(metaEntity, data);

        return root;
    }

    static List<MetaData> addChildren(MetaData metaData, MetaData newChildren) {
        List<MetaData> children = metaData.getChildren();
        if (children.isEmpty()) {
            children = new ArrayList<>();
        }
        children.add(newChildren);
        return children;
    }

    private static void buildMetaDataFromEntityPropertiesRecursively(MetaEntity metaEntity, MetaData data) {
        for (MetaProperty metaProperty : metaEntity.getProperties()) {
            MetaData metaData = new MetaData();
            metaData.setName(metaProperty.getName());
            metaData.setDescription(metaProperty.getDescription());
            metaData.setDataType(metaProperty.getDataType());
            metaData.setIsArray(metaProperty.getDataType() == MetaDataTypeEnum.ARRAY);
            metaData.setIsRequired(metaProperty.getIsRequired());
            metaData.setIsUnique(metaProperty.getIsUnique());
            metaData.setDefaultValue(metaProperty.getDefaultValue());
            metaData.setExample(metaProperty.getExample());
            metaData.setDataFormat(metaProperty.getDataFormat());
            metaData.setReferencedProperty(metaProperty);

            metaData.setParent(data);

            data.setChildren(addChildren(data, metaData));

            if (metaProperty.getReferencedEntity() != null) {
                // recursive
                buildMetaDataFromEntityPropertiesRecursively(metaProperty.getReferencedEntity(), metaData);
            }

        }
    }

    public static MetaData orderProductFailure(MetaEntity metaEntity) {
        MetaData root = new MetaData();
        root.setName("orderProductFailure");
        root.setDescription("orderProductFailure");
        root.setDataType(MetaDataTypeEnum.OBJECT);
        root.setIsArray(false);

        root.setIsRequired(true);
        root.setIsUnique(false);
        root.setDefaultValue("");
        root.setExample("");
        root.setDataFormat(null);
        root.setReferencedProperty(null);

        root.setParent(null);

        // result
        MetaData result = new MetaData();
        result.setName("result");
        result.setDescription("result");
        result.setDataType(MetaDataTypeEnum.NUMBER);
        result.setIsArray(false);

        result.setIsRequired(true);
        result.setIsUnique(false);
        result.setDefaultValue("");
        result.setExample("");
        result.setDataFormat(null);
        result.setReferencedProperty(null);
        result.setParent(root);

        root.setChildren(addChildren(root, result));

        return root;
    }

    public static MetaData orderProductUnexpectedException(MetaEntity metaEntity) {
        MetaData root = new MetaData();
        root.setName("orderProductUnexpectedException");
        root.setDescription("orderProductUnexpectedException");
        root.setDataType(MetaDataTypeEnum.OBJECT);
        root.setIsArray(false);

        root.setIsRequired(true);
        root.setIsUnique(false);
        root.setDefaultValue("");
        root.setExample("");
        root.setDataFormat(null);
        root.setReferencedProperty(null);

        root.setParent(null);

        // result
        MetaData result = new MetaData();
        result.setName("exception");
        result.setDescription("exception");
        result.setDataType(MetaDataTypeEnum.STRING);
        result.setIsArray(false);

        result.setIsRequired(true);
        result.setIsUnique(false);
        result.setDefaultValue("");
        result.setExample("");
        result.setDataFormat(null);
        result.setReferencedProperty(null);
        result.setParent(root);

        root.setChildren(addChildren(root, result));

        return root;
    }
}
