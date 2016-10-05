package com.project5.snakeintheforest.Models;

public class Score {
    private int score = 0;

    void increaseScore() {
        score += 20;
    }

    void decreaseScore() {
        score -= 20;
    }

    void boostScore() {
        score += 100;
    }

    public int getScore() {
        return score;
    }

}
