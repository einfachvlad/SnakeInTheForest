package com.project5.snakeintheforest.Models;

public class Position {
    private int X;
    private int Y;

    public Position() {
        X = 0;
        Y = 0;
    }

    Position(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void setPosition(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
