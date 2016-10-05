package com.project5.snakeintheforest.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.project5.snakeintheforest.ActivitiesListeners.ChooseLevelMenuButtonController;
import com.project5.snakeintheforest.R;

public class ChooseLevelMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.level_choose_menu);

        Button normalLevelButton = (Button) findViewById(R.id.normalLevelButton);
        Button proLevelButton = (Button) findViewById(R.id.proLevelButton);
        ChooseLevelMenuButtonController chooseLevelMenuButtonController = new ChooseLevelMenuButtonController(this);
        normalLevelButton.setOnClickListener(chooseLevelMenuButtonController);
        proLevelButton.setOnClickListener(chooseLevelMenuButtonController);

    }
}
