package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.project5.snakeintheforest.Activities.PauseActivity;

public class PauseListener implements OnClickListener{
        private Activity activity;
        public PauseListener(Activity activity){
            this.activity=activity;
        }
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(activity, PauseActivity.class);
            activity.startActivity(intent);
        }
}
