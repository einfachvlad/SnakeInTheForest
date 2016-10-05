package com.project5.snakeintheforest.Models;

public class Player {
    String nickname;
    String score;

    public Player() {
        nickname ="";
        score ="";
    }

    public Player(String nickname, String score) {
        this.nickname = nickname;
        this.score = score;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public String getNickname() {
        return nickname;
    }
}
