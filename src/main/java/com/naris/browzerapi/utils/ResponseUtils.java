package com.naris.browzerapi.utils;

import static com.naris.browzerapi.global.StaticValues.ITEM_DELETED;

public class ResponseUtils {
    private String value;
    private String attribute;

    private ResponseUtils(String value, String attribute) {
        this.value = value;
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public static ResponseUtils buildCustomResponse(String value, String attribute) {
        return new ResponseUtils(value, attribute);
    }

    public static ResponseUtils buildDeletedResponse(String deletedItem) {
        return new ResponseUtils(deletedItem, ITEM_DELETED);
    }
}
