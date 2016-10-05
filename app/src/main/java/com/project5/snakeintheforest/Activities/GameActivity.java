package com.project5.snakeintheforest.Activities;


import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project5.snakeintheforest.ActivitiesListeners.GameButtonsListener;
import com.project5.snakeintheforest.ActivitiesListeners.PauseListener;
import com.project5.snakeintheforest.GameSurface;
import com.project5.snakeintheforest.GraphUpdater;
import com.project5.snakeintheforest.Models.RandomGenerator;
import com.project5.snakeintheforest.R;
import com.project5.snakeintheforest.Models.Score;
import com.project5.snakeintheforest.StepUpdater;
import com.project5.snakeintheforest.ActivitiesListeners.TapListener;

public class GameActivity extends Activity {
    FrameLayout mainLayout;
    GameSurface surf;
    Timer timer;
    public Score score;
    public TextView scoreView;
    TextView binaryNumber;
    TextView normalNumber;
    ImageButton pauseButton;
    RandomGenerator randomGenerator = new RandomGenerator();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        surf = new GameSurface(this);
        this.setContentView(R.layout.game_field);

        mainLayout = (FrameLayout) findViewById(R.id.gameLayout);
        mainLayout.addView(surf);
        TapListener tapListener = new TapListener(surf.gameArea.getSnake());
        mainLayout.setOnTouchListener(tapListener);

        pauseButton = (ImageButton) findViewById(R.id.pauseButton);
        PauseListener pauseButtonListener = new PauseListener(this);
        pauseButton.setOnClickListener(pauseButtonListener);

        ImageButton upButton=(ImageButton)findViewById(R.id.uparrow);
        ImageButton downButton=(ImageButton)findViewById(R.id.downarrow);
        ImageButton leftButton=(ImageButton)findViewById(R.id.leftarrow);
        ImageButton rightButton=(ImageButton)findViewById(R.id.rightarrow);

        GameButtonsListener gameButtonsListener=new GameButtonsListener(surf.gameArea.getSnake());
        upButton.setOnClickListener(gameButtonsListener);
        downButton.setOnClickListener(gameButtonsListener);
        leftButton.setOnClickListener(gameButtonsListener);
        rightButton.setOnClickListener(gameButtonsListener);

        timer = new Timer();
        score = new Score();
        scoreView = (TextView) findViewById(R.id.score);
        normalNumber = (TextView) findViewById(R.id.normalNumber);
        binaryNumber = (TextView) findViewById(R.id.binaryNumber);

        Intent intent = getIntent();
        if (intent.getBooleanExtra("visibility", false))
            binaryNumber.setVisibility(View.VISIBLE);

        randomGenerator.setNumbersViews(normalNumber, binaryNumber);
        randomGenerator.generateRandom(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onResume() {
        super.onResume();
        timer = new Timer();
        timer.schedule(new GraphUpdater(surf), 0, 100);
        timer.schedule(new StepUpdater(this), 0, 250);
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
        timer.purge();
    }

    @Override
    public void onStop() {
        super.onStop();
        timer.cancel();
        timer.purge();
    }

    public void Step() {
        if(surf.gameArea.getSnake().getBinaryNumber().nextNumber){
            randomGenerator.generateRandom(this);
            surf.gameArea.getSnake().getBinaryNumber().nextNumber=false;
        }
        if (!surf.gameArea.getSnake().nextMove(surf.gameArea.getField(), score,new StringBuffer(binaryNumber.getText()))) {
            Intent intent = new Intent(this, GameOverActivity.class);
            intent.putExtra("score", score.getScore());
            startActivity(intent);
            this.onStop();
            this.finish();
        }
    }
}