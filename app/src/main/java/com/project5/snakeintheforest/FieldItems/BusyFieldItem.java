package com.project5.snakeintheforest.FieldItems;

import com.project5.snakeintheforest.Models.Field;

public class BusyFieldItem extends FieldItem {
    public static boolean isBusy(int X, int Y, Field field) {
        return (field.getField()[X][Y] instanceof BusyFieldItem);
    }
}
