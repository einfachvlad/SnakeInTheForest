package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project5.snakeintheforest.Activities.ChooseLevelMenuActivity;
import com.project5.snakeintheforest.Models.Player;
import com.project5.snakeintheforest.Models.PlayerParser;
import com.project5.snakeintheforest.Models.Players;
import com.project5.snakeintheforest.R;

public class GameOverButtonController implements OnClickListener {
    private Activity activity;
    private Players players;

    public GameOverButtonController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okButton:
                Button okButton=(Button)view;
                okButton.setVisibility(View.GONE);

                Button tryAgainButton=(Button)activity.findViewById(R.id.tryAgainButton);
                tryAgainButton.setVisibility(View.VISIBLE);

                EditText nickname=(EditText)activity.findViewById(R.id.playersName);
                TextView score=(TextView)activity.findViewById(R.id.finalScore);
                Player player=new Player(nickname.getText().toString(),score.getText().toString());

                PlayerParser playerParser=new PlayerParser(activity);
                players=playerParser.parse();
                players.addPlayer(player);
                playerParser.writeXML(players);
                break;
            case R.id.tryAgainButton:
                Intent intent = new Intent(activity, ChooseLevelMenuActivity.class);
                activity.startActivity(intent);
                activity.finish();
                break;
        }
    }
}