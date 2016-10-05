package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.project5.snakeintheforest.Activities.ChooseLevelMenuActivity;
import com.project5.snakeintheforest.Activities.LeaderboardActivity;
import com.project5.snakeintheforest.Activities.StartMenuActivity;
import com.project5.snakeintheforest.R;

public class StartMenuButtonController implements OnClickListener {
    private Activity activity;

    public StartMenuButtonController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quitButton:
                activity.showDialog(StartMenuActivity.DIALOG_EXIT);
                break;
            case R.id.playButton:
                Intent playIntent = new Intent(activity, ChooseLevelMenuActivity.class);
                activity.startActivity(playIntent);
                break;
            case R.id.leaderboardButton:
                Intent leaderboardIntent=new Intent(activity, LeaderboardActivity.class);
                activity.startActivity(leaderboardIntent);
                break;
        }
    }

}
