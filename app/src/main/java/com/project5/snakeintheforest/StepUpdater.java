package com.project5.snakeintheforest;

import com.project5.snakeintheforest.Activities.GameActivity;

import java.util.TimerTask;

public class StepUpdater extends TimerTask {

    GameActivity act;

   public StepUpdater(GameActivity s) {
        this.act = s;
    }

    @Override
    public void run() {
        act.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                act.scoreView.setText("Score: " + String.valueOf(act.score.getScore()));
            }
        });
        act.Step();

    }

}