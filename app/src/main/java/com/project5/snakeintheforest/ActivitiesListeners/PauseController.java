package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.project5.snakeintheforest.Activities.StartMenuActivity;
import com.project5.snakeintheforest.R;

public class PauseController implements OnClickListener {
    private Activity activity;
    public PauseController(Activity activity){
        this.activity=activity;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continueButton:
                activity.finish();
                break;
            case R.id.exitToMainActivityButton:
                Intent intent = new Intent(activity.getApplicationContext(), StartMenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(intent);
        }
    }
}
