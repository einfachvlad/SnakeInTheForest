package com.project5.snakeintheforest.FieldItems;

import com.project5.snakeintheforest.Models.Field;

public class BarrierFieldItem extends FieldItem {
    public static boolean isBarried(int X, int Y, Field field) {
        return (field.getField()[X][Y] instanceof BarrierFieldItem);
    }
}
