package com.project5.snakeintheforest.FieldItems;

import com.project5.snakeintheforest.Models.Field;

public class AppleFieldItem extends EatableFieldItem {

    public static boolean isApple(int X, int Y, Field field) {
        return (field.getField()[X][Y] instanceof AppleFieldItem);
    }

    public static void addApple(Field field) {
        boolean foundPosition = false;
        while (!foundPosition) {
            int X = (int) (Math.random() * field.getFieldX());
            int Y = (int) (Math.random() * field.getFieldY());
            if (EmptyFieldItem.isEmpty(X, Y, field)) {
                field.getField()[X][Y] = new AppleFieldItem();
                foundPosition = true;
            }
        }
    }
}
