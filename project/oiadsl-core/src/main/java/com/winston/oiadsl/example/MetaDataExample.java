package com.winston.oiadsl.example;

import com.winston.oiadsl.constant.MetaDataTypeEnum;
import com.winston.oiadsl.entity.MetaData;
import com.winston.oiadsl.entity.MetaEntity;
import com.winston.oiadsl.entity.MetaProperty;

import java.util.ArrayList;
import java.util.List;

public class MetaDataExample {

    public static MetaData orderProductOutputSuccessful(MetaEntity metaEntity) {
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


    public static MetaData orderProductOutputFailure(MetaEntity metaEntity) {
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

    public static MetaData orderProductOutputUnexpectedException(MetaEntity metaEntity) {
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

    public static MetaData orderProductInput(MetaEntity metaEntity, MetaProperty productCodeProperty,
                                             MetaProperty productPriceProperty, MetaProperty productNameProperty) {
        // root
        MetaData root = new MetaData();
        root.setName("orderProductInput");
        root.setDescription("orderProductInput");
        root.setDataType(MetaDataTypeEnum.OBJECT);
        root.setIsArray(false);
        root.setIsRequired(true);
        root.setIsUnique(false);
        root.setDefaultValue("");
        root.setExample("");
        root.setDataFormat(null);
        root.setReferencedProperty(null);
        root.setParent(null);

        // products
        MetaData products = new MetaData();
        products.setName("products");
        products.setDescription("products");
        products.setDataType(MetaDataTypeEnum.ARRAY);
        products.setIsArray(true);
        products.setIsRequired(true);
        products.setIsUnique(false);
        products.setDefaultValue("");
        products.setExample("");
        products.setDataFormat(null);
        products.setReferencedProperty(null);
        products.setParent(root);

        root.setChildren(addChildren(root, products));

        // product's code
        MetaData productCode = new MetaData();
        productCode.setName("code");
        productCode.setDescription("code");
        productCode.setDataType(MetaDataTypeEnum.STRING);
        productCode.setIsArray(false);
        productCode.setIsRequired(true);
        productCode.setIsUnique(false);
        productCode.setDefaultValue("");
        productCode.setExample("");
        productCode.setDataFormat(null);
        productCode.setReferencedProperty(productCodeProperty);
        productCode.setParent(products);

        products.setChildren(addChildren(products, productCode));

        // product's quantity
        MetaData productQuantity = new MetaData();
        productQuantity.setName("quantity");
        productQuantity.setDescription("quantity");
        productQuantity.setDataType(MetaDataTypeEnum.NUMBER);
        productQuantity.setIsArray(false);
        productQuantity.setIsRequired(true);
        productQuantity.setIsUnique(false);
        productQuantity.setDefaultValue("");
        productQuantity.setExample("");
        productQuantity.setDataFormat(null);
        productQuantity.setReferencedProperty(productCodeProperty);
        productQuantity.setParent(products);

        products.setChildren(addChildren(products, productQuantity));

        // product's price
        MetaData productPrice = new MetaData();
        productPrice.setName("price");
        productPrice.setDescription("price");
        productPrice.setDataType(MetaDataTypeEnum.NUMBER);
        productPrice.setIsArray(false);
        productPrice.setIsRequired(true);
        productPrice.setIsUnique(false);
        productPrice.setDefaultValue("");
        productPrice.setExample("");
        productPrice.setDataFormat(null);
        productPrice.setReferencedProperty(productPriceProperty);
        productPrice.setParent(products);

        products.setChildren(addChildren(products, productPrice));

        // product's name, not required
        MetaData productName = new MetaData();
        productName.setName("name");
        productName.setDescription("name");
        productName.setDataType(MetaDataTypeEnum.STRING);
        productName.setIsArray(false);
        productName.setIsRequired(false);
        productName.setIsUnique(false);
        productName.setDefaultValue("");
        productName.setExample("");
        productName.setDataFormat(null);
        productName.setReferencedProperty(productNameProperty);
        productName.setParent(products);

        products.setChildren(addChildren(products, productName));

        return root;
    }

    static List<MetaData> addChildren(MetaData metaData, MetaData newChildren) {
        List<MetaData> children = metaData.getChildren();
        if (children == null) {
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

    public static MetaData orderCancelInput(MetaEntity metaEntity, MetaProperty code) {
        // root
        MetaData root = new MetaData();
        root.setName("orderCancelInput");
        root.setDescription("orderCancelInput");
        root.setDataType(MetaDataTypeEnum.ARRAY);
        root.setIsArray(false);
        root.setIsRequired(true);
        root.setIsUnique(false);
        root.setDefaultValue("");
        root.setExample("");
        root.setDataFormat(null);
        root.setReferencedProperty(null);
        root.setParent(null);

        // order's code
        MetaData orderCode = new MetaData();
        orderCode.setName("order code");
        orderCode.setDescription("code of order");
        orderCode.setDataType(MetaDataTypeEnum.STRING);
        orderCode.setIsArray(false);
        orderCode.setIsRequired(true);
        orderCode.setIsUnique(false);
        orderCode.setDefaultValue("");
        orderCode.setExample("");
        orderCode.setDataFormat(null);
        orderCode.setReferencedProperty(code);
        orderCode.setParent(root);

        root.setChildren(addChildren(root, orderCode));

        return root;
    }

    public static MetaData orderCancelOutputSuccessful(MetaEntity metaEntity) {
        MetaData root = new MetaData();
        root.setName("orderCancelSuccessful");
        root.setDescription("orderCancelSuccessful");
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

    public static MetaData orderCancelOutputFailure(MetaEntity metaEntity) {
        MetaData root = new MetaData();
        root.setName("orderCancelFailure");
        root.setDescription("orderCancelFailure");
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
}
