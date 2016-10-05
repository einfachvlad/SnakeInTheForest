package com.project5.snakeintheforest.FieldItems;

import com.project5.snakeintheforest.Models.Field;

public class MushroomFieldItem extends EatableFieldItem {

    public static boolean isMushroom(int X, int Y, Field field) {
        return (field.getField()[X][Y] instanceof MushroomFieldItem);
    }

    public static void addMushroom(Field field) {
        boolean foundPosition = false;
        while (!foundPosition) {
            int X = (int) (Math.random() * field.getFieldX());
            int Y = (int) (Math.random() * field.getFieldY());
            if (EmptyFieldItem.isEmpty(X, Y, field)) {
                field.getField()[X][Y] = new MushroomFieldItem();
                foundPosition = true;
            }
        }
    }
}
