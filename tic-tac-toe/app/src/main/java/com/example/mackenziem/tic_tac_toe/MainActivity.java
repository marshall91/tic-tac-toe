package com.example.mackenziem.tic_tac_toe;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static final String LOGTAG = "MAIN";

    private Button[][] tiles;

    private String turnSymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiles = new Button[3][3];

        tiles[0][0] = (Button) findViewById(R.id.button00);
        tiles[0][1] = (Button) findViewById(R.id.button01);
        tiles[0][2] = (Button) findViewById(R.id.button02);
        tiles[1][0] = (Button) findViewById(R.id.button10);
        tiles[1][1] = (Button) findViewById(R.id.button11);
        tiles[1][2] = (Button) findViewById(R.id.button12);
        tiles[2][0] = (Button) findViewById(R.id.button20);
        tiles[2][1] = (Button) findViewById(R.id.button21);
        tiles[2][2] = (Button) findViewById(R.id.button22);

        int[] range = {0,1,2};
        for (int i : range) {
            for (Button b : tiles[i]) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateButtonState((Button) v);
                    }
                });
            }
        }


        Button reset = (Button) findViewById(R.id.reset);

        turnSymbol = "X";

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons();
                turnSymbol = "X";
            }
        });

        Log.d(LOGTAG, "onCreate");
    }

    private void updateButtonState(Button b) {
        if (b.getText().equals("")) {
            b.setText(turnSymbol);
            if (checkForWin()) {
                Context context = getApplicationContext();
                CharSequence text = turnSymbol + " wins!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                toggleTurnSymbol();
            }
        }
    }

    private void toggleTurnSymbol() {
        if(turnSymbol.equals("X")) {
            turnSymbol = "O";
        } else {
            turnSymbol = "X";
        }
    }

    private boolean checkForWin() {
        int[] range = {0,1,2};

        // Rows
        for (int i : range) {
            if (tiles[i][0].getText().equals(tiles[i][1].getText())
                    && tiles[i][1].getText().equals(tiles[i][2].getText())
                    && !(tiles[i][0].getText().equals("")
                    || tiles[i][1].getText().equals("")
                    || tiles[i][2].getText().equals("")
            )) {
                return true;
            }
        }

        // Cols
        for (int i : range) {
            if (tiles[0][i].getText().equals(tiles[1][i].getText())
                    && tiles[1][i].getText().equals(tiles[2][i].getText())
                    && !(tiles[0][i].getText().equals("")
                    || tiles[1][i].getText().equals("")
                    || tiles[2][i].getText().equals("")
            )) {
                return true;
            }
        }

        // Diag Down
        if (tiles[0][0].getText().equals(tiles[1][1].getText())
                && tiles[1][1].getText().equals(tiles[2][2].getText())
                && !(tiles[0][0].getText().equals("")
                || tiles[1][1].getText().equals("")
                || tiles[2][2].getText().equals("")
        )) {
            return true;
        }
        // Diag Up
        if (tiles[2][0].getText().equals(tiles[1][1].getText())
                && tiles[1][1].getText().equals(tiles[0][2].getText())
                && !(tiles[2][0].getText().equals("")
                || tiles[1][1].getText().equals("")
                || tiles[0][2].getText().equals("")
        )) {
            return true;
        }

        return false;
    }

    private void resetButtons() {
        int[] range = {0,1,2};
        for (int i : range) {
            for (Button b : tiles[i]) {
                b.setText("");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
