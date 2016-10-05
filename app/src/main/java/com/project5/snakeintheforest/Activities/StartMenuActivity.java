package com.project5.snakeintheforest.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.project5.snakeintheforest.ActivitiesListeners.QuitDialogListener;
import com.project5.snakeintheforest.Models.PlayerParser;
import com.project5.snakeintheforest.R;
import com.project5.snakeintheforest.ActivitiesListeners.StartMenuButtonController;

public class StartMenuActivity extends Activity {
    public static final int DIALOG_EXIT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_menu);

        Button playButton = (Button) findViewById(R.id.playButton);
        Button leaderboardButton = (Button) findViewById(R.id.leaderboardButton);
        Button quitButton = (Button) findViewById(R.id.quitButton);
        StartMenuButtonController startMenuButtonController = new StartMenuButtonController(this);

        playButton.setOnClickListener(startMenuButtonController);
        leaderboardButton.setOnClickListener(startMenuButtonController);
        quitButton.setOnClickListener(startMenuButtonController);
    }
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            QuitDialogListener quitDialogListener=new QuitDialogListener(this);
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setMessage(R.string.quitQuestion);
            adb.setPositiveButton(R.string.yes, quitDialogListener);
            adb.setNegativeButton(R.string.no, quitDialogListener);

            return adb.create();
        }
        return onCreateDialog(id);
    }
    public void onBackPressed() {
        showDialog(StartMenuActivity.DIALOG_EXIT);
    }
}
