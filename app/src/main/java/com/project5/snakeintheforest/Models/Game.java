package com.project5.snakeintheforest.Models;

import com.project5.snakeintheforest.FieldItems.AppleFieldItem;
import com.project5.snakeintheforest.FieldItems.MushroomFieldItem;
import com.project5.snakeintheforest.FieldItems.PearFieldItem;
import com.project5.snakeintheforest.Models.Field;
import com.project5.snakeintheforest.Models.Snake;

public class Game {
    private Field field;
    private Snake snake;

    public Game() {
        field = new Field();
        snake = new Snake(field);
        for (int count = 0; count < 5; count++) {
            AppleFieldItem.addApple(field);
            PearFieldItem.addPear(field);
            MushroomFieldItem.addMushroom(field);
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public Field getField() {
        return field;
    }
}
