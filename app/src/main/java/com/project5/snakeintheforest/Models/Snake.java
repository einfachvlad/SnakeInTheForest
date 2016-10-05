package com.project5.snakeintheforest.Models;

import com.project5.snakeintheforest.Direction;
import com.project5.snakeintheforest.FieldItems.AppleFieldItem;
import com.project5.snakeintheforest.FieldItems.BarrierFieldItem;
import com.project5.snakeintheforest.FieldItems.BusyFieldItem;
import com.project5.snakeintheforest.FieldItems.EmptyFieldItem;
import com.project5.snakeintheforest.FieldItems.EatableFieldItem;
import com.project5.snakeintheforest.FieldItems.MushroomFieldItem;
import com.project5.snakeintheforest.FieldItems.PearFieldItem;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private BinaryNumber binaryNumber = new BinaryNumber();
    private List<Position> snake = new ArrayList<>();
    private int direction = Direction.EAST;

    Snake(Field field) {
        snake.add(new Position(2, 3));
        snake.add(new Position(3, 3));
        snake.add(new Position(4, 3));
        field.getField()[2][3] = new BusyFieldItem();
        field.getField()[3][3] = new BusyFieldItem();
        field.getField()[4][3] = new BusyFieldItem();

    }

    public List<Position> getSnake() {
        return snake;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public BinaryNumber getBinaryNumber() {
        return binaryNumber;
    }

    public int getSnakeLength() {
        return snake.size();
    }

    public int getDirection() {
        return direction;
    }

    public boolean nextMove(Field field, Score score, StringBuffer binaryNumber) {
        if (snake.isEmpty())
            return false;
        switch (direction) {
            case Direction.NORTH: {
                int nextX = snake.get(snake.size() - 1).getX();
                int nextY = snake.get(snake.size() - 1).getY() - 1;
                if ((nextY >= 0) && EmptyFieldItem.isEmpty(nextX, nextY, field)) {
                    move(field, score, nextX, nextY);
                    return true;
                } else if ((nextY >= 0) && BarrierFieldItem.isBarried(nextX, nextY, field)) {
                    return false;
                } else if ((nextY >= 0) && EatableFieldItem.isEatable(nextX, nextY, field)) {
                    eat(field, score, nextX, nextY, binaryNumber);
                    return !snake.isEmpty();
                } else {
                    return false;
                }
            }

            case Direction.EAST: {
                int nextX = snake.get(snake.size() - 1).getX() + 1;
                int nextY = snake.get(snake.size() - 1).getY();
                if ((nextX < field.getFieldX()) && EmptyFieldItem.isEmpty(nextX, nextY, field)) {
                    move(field, score, nextX, nextY);
                    return true;
                } else if ((nextX < field.getFieldX()) && BarrierFieldItem.isBarried(nextX, nextY, field)) {
                    return false;
                } else if ((nextX < field.getFieldX()) && EatableFieldItem.isEatable(nextX, nextY, field)) {
                    eat(field, score, nextX, nextY, binaryNumber);
                    return !snake.isEmpty();
                } else {
                    return false;
                }
            }
            case Direction.SOUTH: {
                int nextX = snake.get(snake.size() - 1).getX();
                int nextY = snake.get(snake.size() - 1).getY() + 1;
                if ((nextY < field.getFieldY()) && EmptyFieldItem.isEmpty(nextX, nextY, field)) {
                    move(field, score, nextX, nextY);
                    return true;
                } else if ((nextY < field.getFieldY()) && BarrierFieldItem.isBarried(nextX, nextY, field)) {
                    return false;
                } else if ((nextY < field.getFieldY()) && EatableFieldItem.isEatable(nextX, nextY, field)) {
                    eat(field, score, nextX, nextY, binaryNumber);
                    return !snake.isEmpty();
                } else {
                    return false;
                }
            }
            case Direction.WEST: {
                int nextX = snake.get(snake.size() - 1).getX() - 1;
                int nextY = snake.get(snake.size() - 1).getY();
                if ((nextX >= 0) && EmptyFieldItem.isEmpty(nextX, nextY, field)) {
                    move(field, score, nextX, nextY);
                    return true;
                } else if ((nextX >= 0) && BarrierFieldItem.isBarried(nextX, nextY, field)) {
                    return false;
                } else if ((nextX >= 0) && EatableFieldItem.isEatable(nextX, nextY, field)) {
                    eat(field, score, nextX, nextY, binaryNumber);
                    return !snake.isEmpty();
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private void eat(Field field, Score score, int nextX, int nextY, StringBuffer binaryNumber) {

        if (MushroomFieldItem.isMushroom(nextX, nextY, field)) {
            MushroomFieldItem.addMushroom(field);
            this.binaryNumber.delete();
            reduce(field, score);
            field.getField()[nextX][nextY] = new EmptyFieldItem();
        } else {
            snake.add(new Position(nextX, nextY));
            if (AppleFieldItem.isApple(nextX, nextY, field)) {
                AppleFieldItem.addApple(field);
                this.binaryNumber.add(0);
            } else {
                PearFieldItem.addPear(field);
                this.binaryNumber.add(1);
            }
            score.increaseScore();
            field.getField()[nextX][nextY] = new BusyFieldItem();
        }
        workWithBinaryNumber(field, score, binaryNumber);
    }

    private void reduce(Field field, Score score) {
        score.decreaseScore();
        field.getField()[snake.get(0).getX()][snake.get(0).getY()] = new EmptyFieldItem();
        snake.remove(0);
    }

    private void move(Field field, Score score, int nextX, int nextY) {
        field.getField()[snake.get(0).getX()][snake.get(0).getY()] = new EmptyFieldItem();
        snake.remove(0);
        snake.add(new Position(nextX, nextY));
        field.getField()[nextX][nextY] = new BusyFieldItem();
    }

    private void workWithBinaryNumber(Field field, Score score, StringBuffer number) {
        if (binaryNumber.isEqualSize(number)) {
            if (binaryNumber.isEqual(number)) {
                score.boostScore();
                binaryNumber.nextNumber = true;
            } else {
                int size = binaryNumber.size();
                for (int index = 0; index < size; index++)
                    reduce(field, score);
            }
            binaryNumber.clear();
        }
    }
}
