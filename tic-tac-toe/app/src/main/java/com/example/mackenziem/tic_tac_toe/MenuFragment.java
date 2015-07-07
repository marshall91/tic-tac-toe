package com.example.mackenziem.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private ArrayAdapter<String> mGameAdapter;
    private int gameNum;

    public MenuFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        gameNum = 1;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_create_game) {
            String gameString = "Game " + gameNum;
            gameNum++;
            mGameAdapter.add(gameString);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        List<String> games = new ArrayList<String>();
        mGameAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_game,
                R.id.list_item_game_textview,
                games
        );

        ListView listView = (ListView) rootView.findViewById(R.id.listview_game);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameActivity activity = new GameActivity();
                Intent intent = new Intent(getActivity(), activity.getClass());
                startActivity(intent);
            }
        });
        listView.setAdapter(mGameAdapter);

        return rootView;
    }
}
