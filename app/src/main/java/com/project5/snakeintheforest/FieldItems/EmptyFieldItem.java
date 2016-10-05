package com.project5.snakeintheforest.FieldItems;

import com.project5.snakeintheforest.Models.Field;

public class EmptyFieldItem extends FieldItem {
   public static boolean isEmpty(int X, int Y, Field field) {
        return (field.getField()[X][Y] instanceof EmptyFieldItem);
    }
}
