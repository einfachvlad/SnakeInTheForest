package com.project5.snakeintheforest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

import com.project5.snakeintheforest.FieldItems.AppleFieldItem;
import com.project5.snakeintheforest.FieldItems.EatableFieldItem;
import com.project5.snakeintheforest.FieldItems.PearFieldItem;
import com.project5.snakeintheforest.Models.Game;

public class GameSurface extends SurfaceView {

    public Game gameArea;
    Bitmap headOfSnake, tailOfSnake, bodyOfSnake, background, apple, pear, mushroom;
    int width;
    int height;
    int fieldItemWidth;
    int fieldItemHeight;
    int bgfieldItemWidth;
    int bgfieldItemHeight;
    Bitmap bg;
    Bitmap head;
    Bitmap body;
    Bitmap tail;
    Bitmap appleBitmap;
    Bitmap pearBitmap;
    Bitmap mushroomBitmap;

    public GameSurface(Context context) {
        super(context);
        gameArea = new Game();

        headOfSnake = BitmapFactory.decodeResource(getResources(),
                R.drawable.headofsnake);
        tailOfSnake = BitmapFactory.decodeResource(getResources(),
                R.drawable.tailofsnake);
        bodyOfSnake = BitmapFactory.decodeResource(getResources(),
                R.drawable.bodyofsnake);

        background = BitmapFactory.decodeResource(getResources(),
                R.drawable.background);

        apple = BitmapFactory.decodeResource(getResources(),
                R.drawable.apple);
        pear = BitmapFactory.decodeResource(getResources(), R.drawable.pear);
        mushroom = BitmapFactory.decodeResource(getResources(), R.drawable.mushroom);
    }

    void drawField(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        fieldItemWidth = width / gameArea.getField().getFieldX();
        fieldItemHeight = height / gameArea.getField().getFieldY();
        bgfieldItemWidth = width / gameArea.getField().getFieldX() * 5;
        bgfieldItemHeight = height / gameArea.getField().getFieldY() * 5;

        bg = Bitmap.createScaledBitmap(background, width, height, true);
        appleBitmap = Bitmap.createScaledBitmap(apple, fieldItemWidth, fieldItemHeight, true);
        pearBitmap = Bitmap.createScaledBitmap(pear, fieldItemWidth, fieldItemHeight, true);
        mushroomBitmap = Bitmap.createScaledBitmap(mushroom, fieldItemWidth, fieldItemHeight, true);
        canvas.drawBitmap(bg, 0, 0, null);

        for (int indexX = 0; indexX < gameArea.getField().getFieldX(); indexX++) {
            for (int indexY = 0; indexY < gameArea.getField().getFieldY(); indexY++) {
                //canvas.drawBitmap(bg, fieldItemWidth * indexX, fieldItemHeight * indexY, null);
                if (EatableFieldItem.isEatable(indexX, indexY, gameArea.getField())) {
                    if (AppleFieldItem.isApple(indexX, indexY, gameArea.getField()))
                        canvas.drawBitmap(appleBitmap, fieldItemWidth * indexX, fieldItemHeight * indexY, null);
                    else if (PearFieldItem.isPear(indexX, indexY, gameArea.getField()))
                        canvas.drawBitmap(pearBitmap, fieldItemWidth * indexX, fieldItemHeight * indexY, null);
                    else
                        canvas.drawBitmap(mushroomBitmap, fieldItemWidth * indexX, fieldItemHeight * indexY, null);
                }
            }
        }

    }

    void drawSnake(Canvas canvas) {
        int width = headOfSnake.getWidth();
        int height = headOfSnake.getHeight();

        float scaleWidth = fieldItemWidth / (float) width;
        float scaleHeight = fieldItemHeight / (float) height;
        Matrix matrix = new Matrix();
        matrix.setScale(scaleWidth, scaleHeight);

        switch (gameArea.getSnake().getDirection()) {
            case Direction.EAST:
                if (gameArea.getSnake().getSnakeLength() == 1 || gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 1).getX() > gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 2).getX())
                    head = Bitmap.createScaledBitmap(headOfSnake, fieldItemWidth, fieldItemHeight, true);
                body = Bitmap.createScaledBitmap(bodyOfSnake, fieldItemWidth, fieldItemHeight, true);
                if (gameArea.getSnake().getSnakeLength() != 1 && gameArea.getSnake().getSnake().get(0).getX() < gameArea.getSnake().getSnake().get(1).getX())
                    tail = Bitmap.createScaledBitmap(tailOfSnake, fieldItemWidth, fieldItemHeight, true);
                break;
            case Direction.WEST:
                matrix.postRotate(180);
                if (gameArea.getSnake().getSnakeLength() == 1 || gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 1).getX() < gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 2).getX())
                    head = Bitmap.createBitmap(headOfSnake, 0, 0, width, height, matrix, true);
                body = Bitmap.createBitmap(bodyOfSnake, 0, 0, width, height, matrix, true);
                if (gameArea.getSnake().getSnakeLength() != 1 && gameArea.getSnake().getSnake().get(0).getX() > gameArea.getSnake().getSnake().get(1).getX())
                    tail = Bitmap.createBitmap(tailOfSnake, 0, 0, width, height, matrix, true);
                break;
            case Direction.NORTH:
                matrix.postRotate(270);
                if (gameArea.getSnake().getSnakeLength() == 1 || gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 1).getY() < gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 2).getY())
                    head = Bitmap.createBitmap(headOfSnake, 0, 0, width, height, matrix, true);
                body = Bitmap.createBitmap(bodyOfSnake, 0, 0, width, height, matrix, true);
                if (gameArea.getSnake().getSnakeLength() != 1 && gameArea.getSnake().getSnake().get(0).getY() > gameArea.getSnake().getSnake().get(1).getY())
                    tail = Bitmap.createBitmap(tailOfSnake, 0, 0, width, height, matrix, true);
                break;
            case Direction.SOUTH:
                matrix.postRotate(90);
                if (gameArea.getSnake().getSnakeLength() == 1 || gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 1).getY() > gameArea.getSnake().getSnake().get(gameArea.getSnake().getSnakeLength() - 2).getY())
                    head = Bitmap.createBitmap(headOfSnake, 0, 0, width, height, matrix, true);
                body = Bitmap.createBitmap(bodyOfSnake, 0, 0, width, height, matrix, true);
                if (gameArea.getSnake().getSnakeLength() != 1 && gameArea.getSnake().getSnake().get(0).getY() < gameArea.getSnake().getSnake().get(1).getY())
                    tail = Bitmap.createBitmap(tailOfSnake, 0, 0, width, height, matrix, true);
                break;

        }
        if (gameArea.getSnake().getSnake().size() == 1)
            canvas.drawBitmap(head, gameArea.getSnake().getSnake().get(0).getX() * fieldItemWidth, gameArea.getSnake().getSnake().get(0).getY() * fieldItemHeight, null);
        else
            for (int snakesPart = 0; snakesPart < gameArea.getSnake().getSnakeLength(); snakesPart++) {
                if (snakesPart == 0) {
                    canvas.drawBitmap(tail, gameArea.getSnake().getSnake().get(snakesPart).getX() * fieldItemWidth, gameArea.getSnake().getSnake().get(snakesPart).getY() * fieldItemHeight, null);
                } else if (snakesPart == gameArea.getSnake().getSnakeLength() - 1) {
                    canvas.drawBitmap(head, gameArea.getSnake().getSnake().get(snakesPart).getX() * fieldItemWidth, gameArea.getSnake().getSnake().get(snakesPart).getY() * fieldItemHeight, null);
                } else
                    canvas.drawBitmap(body, gameArea.getSnake().getSnake().get(snakesPart).getX() * fieldItemWidth, gameArea.getSnake().getSnake().get(snakesPart).getY() * fieldItemHeight, null);
            }
    }
}
