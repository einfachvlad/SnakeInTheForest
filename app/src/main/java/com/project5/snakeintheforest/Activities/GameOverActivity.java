package com.project5.snakeintheforest.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.project5.snakeintheforest.ActivitiesListeners.GameOverButtonController;
import com.project5.snakeintheforest.R;

public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_menu);
        setContentView(R.layout.lose_game);
        Intent intent=getIntent();
        int score=intent.getIntExtra("score",0);
        Button tryAgainButton = (Button) findViewById(R.id.tryAgainButton);
        Button okButton = (Button) findViewById(R.id.okButton);
        TextView finalScore=(TextView)findViewById(R.id.finalScore);
        finalScore.setText(String.valueOf(score));
        GameOverButtonController gameOverButtonController = new GameOverButtonController(this);
        tryAgainButton.setOnClickListener(gameOverButtonController);
        okButton.setOnClickListener(gameOverButtonController);
    }
}
