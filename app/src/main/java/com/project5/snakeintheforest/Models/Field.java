package com.project5.snakeintheforest.Models;

import com.project5.snakeintheforest.FieldItems.EmptyFieldItem;
import com.project5.snakeintheforest.FieldItems.FieldItem;

public class Field {
    private int fieldX=20;
    private int fieldY=28;
    private FieldItem field[][] = new FieldItem[fieldX][fieldY];
   public Field(){
        for (int indexX = 0; indexX < fieldX; indexX++)
            for (int indexY = 0; indexY < fieldY; indexY++) {
                field[indexX][indexY] = new EmptyFieldItem();
            }
    }
    public FieldItem[][] getField(){
        return field;
    }

    public int getFieldX() {
        return fieldX;
    }

    public int getFieldY() {
        return fieldY;
    }
}
