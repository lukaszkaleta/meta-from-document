package com.hvd.docs.google.document.ai.schema;

import com.google.cloud.documentai.v1.Document;
import com.google.type.DateOrBuilder;
import com.profsys.integrator.common.java.lang.string.BigDecimalString;
import com.profsys.integrator.common.java.lang.string.SeparatedString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Schema {

    private final Logger log = LoggerFactory.getLogger(Schema.class);

    public ReceiptJson receipt(Document document) {
        ReceiptJson receiptJson = new ReceiptJson();

        Field[] lineItemFields = ReceiptJson.LineItem.class.getDeclaredFields();
        Map<String, Field> lineItemFieldMap = Arrays.stream(lineItemFields)
                .collect(Collectors.toMap(field -> field.getName().toLowerCase(), field -> field));

        Field[] fields = receiptJson.getClass().getDeclaredFields();
        Map<String, Field> fieldMap = Arrays.stream(fields)
                .collect(Collectors.toMap(field -> field.getName().toLowerCase(), field -> field));

        List<Document.Entity> entitiesList = document.getEntitiesList();;
        for(Document.Entity entity : entitiesList) {
            float confidence = entity.getConfidence();
            if (confidence > .0) {
                String type = entity.getType();
                String modelType = type.replaceAll("_", "");
                String mentionText = entity.getMentionText();
                Document.Entity.NormalizedValue normalizedValue = entity.getNormalizedValue();
                Field field = fieldMap.get(modelType);
                if (field == null) {
                    throw new IllegalStateException("Model Type is unknown: " + modelType + ":" + type);
                }
                Class<?> typeOfData = field.getType();
                if (typeOfData.isAssignableFrom(List.class)) {
                    List<Document.Entity> propertiesList = entity.getPropertiesList();
                    if ("lineitem".equals(modelType)) {
                        ReceiptJson.LineItem lineItem = new ReceiptJson.LineItem();
                        fillObject(propertiesList, lineItem, lineItemFieldMap);
                        receiptJson.lineItem.add(lineItem);
                    }
                } else {
                    fill(typeOfData, field, receiptJson, mentionText, normalizedValue);
                }
            }
        }
        return receiptJson;
    }

    public InvoiceJson invoice(Document document) {
        InvoiceJson invoiceJson = new InvoiceJson();

        Field[] lineItemFields = InvoiceJson.LineItem.class.getDeclaredFields();
        Map<String, Field> lineItemFieldMap = Arrays.stream(lineItemFields)
                .collect(Collectors.toMap(field -> field.getName().toLowerCase(), field -> field));

        Field[] vatFields = InvoiceJson.Vat.class.getDeclaredFields();
        Map<String, Field> vatFieldMap = Arrays.stream(vatFields)
                .collect(Collectors.toMap(field -> field.getName().toLowerCase(), field -> field));

        Field[] fields = invoiceJson.getClass().getDeclaredFields();
        Map<String, Field> fieldMap = Arrays.stream(fields)
                .collect(Collectors.toMap(field -> field.getName().toLowerCase(), field -> field));

        List<Document.Entity> entitiesList = document.getEntitiesList();;
        for(Document.Entity entity : entitiesList) {
            float confidence = entity.getConfidence();
            if (confidence > .0) {
                String type = entity.getType();
                String modelType = type.replaceAll("_", "");
                String mentionText = entity.getMentionText();
                Document.Entity.NormalizedValue normalizedValue = entity.getNormalizedValue();
                Field field = fieldMap.get(modelType);
                if (field == null) {
                    throw new IllegalStateException("Model Type is unknown: " + modelType + ":" + type);
                }
                Class<?> typeOfData = field.getType();
                if (typeOfData.isAssignableFrom(List.class)) {
                    List<Document.Entity> propertiesList = entity.getPropertiesList();
                    if ("lineitem".equals(modelType)) {
                        InvoiceJson.LineItem lineItem = new InvoiceJson.LineItem();
                        fillObject(propertiesList, lineItem, lineItemFieldMap);
                        invoiceJson.lineItem.add(lineItem);
                    } else if ("vat".equals(modelType)) {
                        InvoiceJson.Vat vat = new InvoiceJson.Vat();
                        fillObject(propertiesList, vat, vatFieldMap);
                        invoiceJson.vat.add(vat);
                    }
                } else {
                    fill(typeOfData, field, invoiceJson, mentionText, normalizedValue);
                }
            }
        }
        return invoiceJson;
    }

    public void fillObject(List<Document.Entity> entities, Object o, Map<String, Field> fieldMap) {
        for(Document.Entity entity : entities) {
            String mentionText = entity.getMentionText();
            Document.Entity.NormalizedValue normalizedValue = entity.getNormalizedValue();
            String type = entity.getType();
            String ourType = new SeparatedString(type, "/").element(1).replaceAll("_", "");
            Field field = fieldMap.get(ourType);
            Class<?> liTypeOfData = field.getType();
            fill(liTypeOfData, field, o, mentionText, normalizedValue);
        }
    }

    public void fill(Class<?> typeOfData, Field field, Object object, String mentionText, Document.Entity.NormalizedValue normalizedValue) {
        String normalizedText = normalizedValue.getText();
        if (typeOfData.isAssignableFrom(String.class)) {
            try {
                field.set(object, mentionText);
            } catch (IllegalAccessException e) {
                log.warn("[{}] String: {}, error: {}", field.getName(), mentionText, e.getMessage());
            }
        } else if (typeOfData.isAssignableFrom(BigDecimal.class)) {
            BigDecimal decimal = null;
            if (normalizedText != null && !normalizedText.isBlank()) {
                try {
                    decimal = new BigDecimal(normalizedText);
                } catch (Exception e) {
                    log.warn("[{}] Normalized text not converted to BigDecimal: {}, error: {}", field.getName(), mentionText, e.getMessage());
                }
            }
            if (decimal == null) {
                decimal = new BigDecimalString(mentionText).get();
            }

            if (decimal != null) {
                try {
                    field.set(object, decimal);
                } catch (IllegalAccessException e) {
                    log.warn("[{}] BigDecimal: {}, error: {}", field.getName(), mentionText, e.getMessage());
                }
            }
        } else if (typeOfData.isAssignableFrom(LocalDate.class)) {
            DateOrBuilder dateValueOrBuilder = normalizedValue.getDateValueOrBuilder();
            LocalDate localDate = null;
            if (!normalizedText.isBlank()) {
                localDate = LocalDate.of(dateValueOrBuilder.getYear(), dateValueOrBuilder.getMonth(), dateValueOrBuilder.getDay());
            }
            try {
                field.set(object, localDate);
            } catch (IllegalAccessException e) {
                log.warn("[{}] LocalDate: {}, error: {}", field.getName(), mentionText, e.getMessage());
            }
        } else if (typeOfData.isAssignableFrom(Integer.class)) {
            Integer value = null;
            try {
                value = Integer.valueOf(normalizedText);
            } catch (Exception e) {
                log.warn("[{}] Normalized text not converted to integer: {}, error: {}", field.getName(), mentionText, e.getMessage());
            }
            if (value != null) {
                try {
                    value = Integer.valueOf(mentionText);
                } catch (Exception e) {
                    log.warn("[{}] Mention text not converted to integer: {}, error: {}", field.getName(), mentionText, e.getMessage());
                }
            }
            try {
                field.set(object, value);
            } catch (IllegalAccessException e) {
                log.warn("[{}] Integer: {}, error: {}", field.getName(), mentionText, e.getMessage());
            }
        }
    }
}

