package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.project5.snakeintheforest.Activities.StartMenuActivity;

public class LeaderBoardController implements OnClickListener {
    Activity activity;
    public LeaderBoardController(Activity activity){
        this.activity=activity;
    }
    @Override
    public void onClick(View v) {
        activity.finish();
    }
}
