package com.project5.snakeintheforest.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.project5.snakeintheforest.ActivitiesListeners.PauseController;
import com.project5.snakeintheforest.R;

public class PauseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pause);
        Button continueButton = (Button) findViewById(R.id.continueButton);
        Button exitButton = (Button) findViewById(R.id.exitToMainActivityButton);
        PauseController pauseController = new PauseController(this);
        continueButton.setOnClickListener(pauseController);
        exitButton.setOnClickListener(pauseController);

    }
}
