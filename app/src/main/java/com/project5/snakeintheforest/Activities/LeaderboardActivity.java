package com.project5.snakeintheforest.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.project5.snakeintheforest.ActivitiesListeners.LeaderBoardController;
import com.project5.snakeintheforest.Models.Player;
import com.project5.snakeintheforest.Models.PlayerParser;
import com.project5.snakeintheforest.Models.Players;
import com.project5.snakeintheforest.R;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends Activity {

    GridView gridView;
    ArrayAdapter<String> adapter;
    Players players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_leaderboard);
        Button backButton=(Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new LeaderBoardController(this));

        PlayerParser playerParser=new PlayerParser(this);
        players=playerParser.parse();
        List<String> data=new ArrayList<>();
        for(Player player:players.getPlayers()){
            data.add(player.getNickname());
            data.add(player.getScore());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        gridView = (GridView) findViewById(R.id.playersGrid);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);
    }
}
