package com.example.mackenziem.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class GameActivity extends ActionBarActivity {
    private static final String LOGTAG = "GAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_game_container, new GameFragment())
                    .commit();
        }
    }

}
