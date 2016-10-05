package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.project5.snakeintheforest.Activities.GameActivity;
import com.project5.snakeintheforest.R;

public class ChooseLevelMenuButtonController implements OnClickListener {
    private Activity activity;

    public ChooseLevelMenuButtonController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normalLevelButton:
                Intent normalLevelButtonIntent = new Intent(activity, GameActivity.class);
                normalLevelButtonIntent.putExtra("visibility",true);
                activity.startActivity(normalLevelButtonIntent);
                activity.finish();
                break;
            case R.id.proLevelButton:
                Intent proLevelButtonIntent = new Intent(activity, GameActivity.class);
                activity.startActivity(proLevelButtonIntent);
                activity.finish();
                break;

        }
    }
}
