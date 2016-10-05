package com.project5.snakeintheforest.ActivitiesListeners;

import android.view.View;
import android.view.View.OnClickListener;

import com.project5.snakeintheforest.Direction;
import com.project5.snakeintheforest.Models.Snake;
import com.project5.snakeintheforest.R;

public class GameButtonsListener implements OnClickListener {
    Snake snake;
    public GameButtonsListener(Snake snake) {
        this.snake = snake;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.uparrow:
                if (snake.getDirection() == Direction.EAST || snake.getDirection() == Direction.WEST)
                snake.setDirection(Direction.NORTH);
                break;
            case R.id.downarrow:
                if (snake.getDirection() == Direction.EAST || snake.getDirection() == Direction.WEST)
                snake.setDirection(Direction.SOUTH);
                break;
            case R.id.leftarrow:
                if (snake.getDirection() == Direction.NORTH || snake.getDirection() == Direction.SOUTH)
                snake.setDirection(Direction.WEST);
                break;
            case R.id.rightarrow:
                if (snake.getDirection() == Direction.NORTH || snake.getDirection() == Direction.SOUTH)
                snake.setDirection(Direction.EAST);
                break;
        }
    }
}
