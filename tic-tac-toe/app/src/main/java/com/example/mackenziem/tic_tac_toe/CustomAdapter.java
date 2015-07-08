package com.example.mackenziem.tic_tac_toe;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private List<String> listOfStrings;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        listOfStrings = objects;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_game, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.gameTextView = (TextView)convertView.findViewById(R.id.list_item_game_textview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        String gameForThisRow = getItem(position);
        viewHolder.gameTextView = (TextView)convertView.findViewById(R.id.list_item_game_textview);
        viewHolder.gameTextView.setText(gameForThisRow);

        return convertView;
    }

    private static class ViewHolder {
        public TextView gameTextView;
    }
}
