package com.project5.snakeintheforest.ActivitiesListeners;

import android.view.MotionEvent;
import android.view.View;

import com.project5.snakeintheforest.Direction;
import com.project5.snakeintheforest.Models.Snake;

public class TapListener implements View.OnTouchListener {
    Snake snake;
    static final float DELTA = 200;
    float x, y, downX, downY, upX, upY;

    public TapListener(Snake snake) {
        this.snake = snake;

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        x = motionEvent.getX();
        y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = x;
                downY = y;
                break;
            case MotionEvent.ACTION_UP:
                upX = x;
                upY = y;
                break;
        }
        if (upX != 0.0 && upY != 0.0) {
            chooseDirection();
            upY = 0.0F;
            upX = 0.0F;
        }
        return true;
    }

    void chooseDirection() {
        if (snake.getDirection() == Direction.NORTH || snake.getDirection() == Direction.SOUTH)
            if (upX > downX && ((upY - downY) < DELTA && (upY - downY) > -DELTA))
                snake.setDirection(Direction.EAST);
            else if (upX < downX && ((upY - downY) < DELTA && (upY - downY) > -DELTA))
                snake.setDirection(Direction.WEST);
        if (snake.getDirection() == Direction.EAST || snake.getDirection() == Direction.WEST)
            if (upY > downY && ((upX - downX) < DELTA && (upX - downX) > -DELTA))
                snake.setDirection(Direction.SOUTH);
            else if (upY < downY && ((upX - downX) < DELTA && (upX - downX) > -DELTA))
                snake.setDirection(Direction.NORTH);
    }
}
