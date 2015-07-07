package com.example.mackenziem.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SplashFragment extends Fragment {

    public SplashFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_splash, container, false);

        Button startGame = (Button) rootView.findViewById(R.id.startGameBtn);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuActivity activity = new MenuActivity();
                Intent intent = new Intent(getActivity(), activity.getClass());
                (getActivity()).startActivity(intent);
            }
        });

        return rootView;
    }
}
