package com.winston.oiadsl.example;

import com.winston.oiadsl.constant.MetaDataTypeEnum;
import com.winston.oiadsl.entity.*;

import java.util.ArrayList;
import java.util.List;

public class EntityExample {

    public MetaEntity generateOrder() {
        MetaEntity metaEntity = new MetaEntity();
        metaEntity.setName("Order");
        metaEntity.setDescription("Users need to place an order when purchasing products.");
        metaEntity.setProperties(generateOrderProperties(metaEntity));
        return metaEntity;
    }

    public MetaEntity generateOrderItem() {
        MetaEntity metaEntity = new MetaEntity();
        metaEntity.setName("OrderItem");
        metaEntity.setDescription("An order can be composed of multiple order items, and each order item can contain multiple products.");
        metaEntity.setProperties(generateOrderItemProperties(metaEntity));
        return metaEntity;
    }

    public MetaEntity generateProduct() {
        MetaEntity metaEntity = new MetaEntity();
        metaEntity.setName("Product");
        metaEntity.setDescription("A product can be purchased by users.");
        metaEntity.setProperties(generateProductProperties(metaEntity));
        return metaEntity;
    }

    private List<MetaProperty> generateOrderProperties(MetaEntity metaEntity) {
        // id
        MetaProperty propId = new MetaProperty();
        propId.setName("id");
        propId.setDescription("The id of the order.");
        propId.setDataType(MetaDataTypeEnum.STRING);
        propId.setExample("123456789");
        propId.setDefaultValue("");
        propId.setIsRequired(true);
        propId.setIsUnique(true);
        propId.setEntity(metaEntity);

        // code
        MetaProperty propCode = new MetaProperty();
        propCode.setName("code");
        propCode.setDescription("The code of the order.");
        propCode.setDataType(MetaDataTypeEnum.STRING);
        propCode.setExample("ORD-0001");
        propCode.setDefaultValue("");
        propCode.setIsRequired(true);
        propCode.setIsUnique(true);
        propCode.setEntity(metaEntity);

        // price
        MetaProperty propPrice = new MetaProperty();
        propPrice.setName("price");
        propPrice.setDescription("The price of the order.");
        propPrice.setDataType(MetaDataTypeEnum.DOUBLE);
        propPrice.setExample("100.00");
        propPrice.setDefaultValue("");
        propPrice.setIsRequired(true);
        propPrice.setIsUnique(false);
        propPrice.setEntity(metaEntity);

        // orderItems
        MetaProperty orderItems = new MetaProperty();
        orderItems.setName("orderItems");
        orderItems.setDescription("The order items of the order.");
        orderItems.setDataType(MetaDataTypeEnum.ARRAY);
        orderItems.setExample("");
        orderItems.setDefaultValue("0");
        orderItems.setIsRequired(true);
        orderItems.setIsUnique(false);
        orderItems.setEntity(metaEntity);
        orderItems.setReferencedEntity("OrderItem");// TODO make it dynamic

        ArrayList<MetaProperty> metaProperties = new ArrayList<>();
        metaProperties.add(propId);
        metaProperties.add(propCode);
        metaProperties.add(propPrice);
        metaProperties.add(orderItems);

        return metaProperties;
    }

    private List<MetaProperty> generateOrderItemProperties(MetaEntity metaEntity) {
        // id
        MetaProperty propOrderItem = new MetaProperty();
        propOrderItem.setName("id");
        propOrderItem.setDescription("The id of the order item.");
        propOrderItem.setDataType(MetaDataTypeEnum.STRING);
        propOrderItem.setExample("123456789");
        propOrderItem.setDefaultValue("");
        propOrderItem.setIsRequired(true);
        propOrderItem.setIsUnique(true);
        propOrderItem.setEntity(metaEntity);

        // quantity
        MetaProperty propQuantity = new MetaProperty();
        propQuantity.setName("quantity");
        propQuantity.setDescription("The quantity of the order item.");
        propQuantity.setDataType(MetaDataTypeEnum.NUMBER);
        propQuantity.setExample("1");
        propQuantity.setDefaultValue("0");
        propQuantity.setIsRequired(true);
        propQuantity.setIsUnique(false);
        propQuantity.setEntity(metaEntity);

        // price
        MetaProperty propPrice = new MetaProperty();
        propPrice.setName("price");
        propPrice.setDescription("The price of the order item.");
        propPrice.setDataType(MetaDataTypeEnum.DOUBLE);
        propPrice.setExample("100.00");
        propPrice.setDefaultValue("");
        propPrice.setIsRequired(true);
        propPrice.setIsUnique(false);
        propPrice.setEntity(metaEntity);

        // products
        MetaProperty products = new MetaProperty();
        products.setName("products");
        products.setDescription("The products of the order item.");
        products.setDataType(MetaDataTypeEnum.ARRAY);
        products.setExample("");
        products.setDefaultValue("0");
        products.setIsRequired(true);
        products.setIsUnique(false);
        products.setEntity(metaEntity);
        products.setReferencedEntity("Product");

        ArrayList<MetaProperty> metaProperties = new ArrayList<>();
        metaProperties.add(propOrderItem);
        metaProperties.add(propQuantity);
        metaProperties.add(propPrice);
        metaProperties.add(products);

        return metaProperties;
    }

    private List<MetaProperty> generateProductProperties(MetaEntity metaEntity) {
        // id
        MetaProperty propId = new MetaProperty();
        propId.setName("id");
        propId.setDescription("The id of the product.");
        propId.setDataType(MetaDataTypeEnum.STRING);
        propId.setExample("123456789");
        propId.setDefaultValue("");
        propId.setIsRequired(true);
        propId.setIsUnique(true);
        propId.setEntity(metaEntity);

        // code
        MetaProperty propName = new MetaProperty();
        propName.setName("code");
        propName.setDescription("The code of the product.");
        propName.setDataType(MetaDataTypeEnum.STRING);
        propName.setExample("Product001");
        propName.setDefaultValue("");
        propName.setIsRequired(true);
        propName.setIsUnique(true);
        propName.setEntity(metaEntity);

        // price
        MetaProperty propPrice = new MetaProperty();
        propPrice.setName("price");
        propPrice.setDescription("The price of the product.");
        propPrice.setDataType(MetaDataTypeEnum.DOUBLE);
        propPrice.setExample("100.00");
        propPrice.setDefaultValue("0");
        propPrice.setIsRequired(true);
        propPrice.setIsUnique(false);
        propPrice.setEntity(metaEntity);

        // stock
        MetaProperty propStock = new MetaProperty();
        propStock.setName("stock");
        propStock.setDescription("The stock of the product.");
        propStock.setDataType(MetaDataTypeEnum.NUMBER);
        propStock.setExample("100");
        propStock.setDefaultValue("0");
        propStock.setIsRequired(true);
        propStock.setIsUnique(false);
        propStock.setEntity(metaEntity);

        ArrayList<MetaProperty> metaProperties = new ArrayList<>();
        metaProperties.add(propId);
        metaProperties.add(propName);
        metaProperties.add(propPrice);
        metaProperties.add(propStock);

        return metaProperties;
    }

    private List<MetaActivity> generateOrderActivities(MetaEntity metaEntity) {
        // order some products
        MetaActivity actOrderProduct = new MetaActivity();
        actOrderProduct.setName("OrderProduct");
        actOrderProduct.setDescription("Order some products.");
        actOrderProduct.setEntity(metaEntity);
        actOrderProduct.setInputs(generateOrderProductInputs(metaEntity));
        actOrderProduct.setOptionalOutputs(generateOrderProductOptionalOutputs(metaEntity));


        return null;
    }

    private List<MetaOutput> generateOrderProductOptionalOutputs(MetaEntity metaEntity) {
        return null;
    }

    private List<MetaInput> generateOrderProductInputs(MetaEntity metaEntity) {
        return null;
    }

    private List<MetaActivity> generateOrderItemActivities(MetaEntity metaEntity) {
        return null;
    }

    private List<MetaActivity> generateProductActivities(MetaEntity metaEntity) {
        return null;
    }

}
