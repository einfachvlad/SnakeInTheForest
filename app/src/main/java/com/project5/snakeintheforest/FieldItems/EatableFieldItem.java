package com.project5.snakeintheforest.FieldItems;

import com.project5.snakeintheforest.Models.Field;

public class EatableFieldItem extends FieldItem {

    public static boolean isEatable(int X, int Y, Field field) {
        return (field.getField()[X][Y] instanceof EatableFieldItem);
    }
}
