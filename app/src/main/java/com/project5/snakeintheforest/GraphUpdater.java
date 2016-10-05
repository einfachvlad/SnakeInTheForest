package com.project5.snakeintheforest;

import java.util.TimerTask;

import android.graphics.Canvas;

public class GraphUpdater extends TimerTask {

    GameSurface surf;

   public GraphUpdater(GameSurface surf){
        this.surf = surf;
    }

    @Override
    public void run() {
        Canvas c = surf.getHolder().lockCanvas();
        if (c!=null){
            surf.drawField(c);
            surf.drawSnake(c);
            surf.getHolder().unlockCanvasAndPost(c);
        }
    }
}