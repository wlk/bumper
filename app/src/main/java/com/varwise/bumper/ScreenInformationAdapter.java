package com.varwise.bumper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by rembam on 12.07.14.
 */
public class ScreenInformationAdapter extends ArrayAdapter<ScreenInformation> {

    private ArrayList<ScreenInformation> items;
    private int textViewResourceId;
    public ScreenInformationAdapter(Context context, int textViewResourceId, ArrayList<ScreenInformation> items) {
        super(context, textViewResourceId, items);
        this.textViewResourceId = textViewResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;
        View v = convertView;

        if (v == null) {
            layout = new RelativeLayout(getContext());
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(textViewResourceId, layout, true);


        }
        else{
            layout = (RelativeLayout) convertView;
        }

        ScreenInformation screenInformation = items.get(position);

        if (screenInformation != null) {
            TextView numberTV = (TextView) layout.findViewById(R.id.numer233322);
            TextView topLine = (TextView) layout.findViewById(R.id.topLine);
            TextView bottomLine = (TextView) layout.findViewById(R.id.secondLine);
            CheckBox checkBox = (CheckBox) layout.findViewById(R.id.checkbox);
            if (numberTV != null) {
                numberTV.setText(screenInformation.getNumber().toString());
            }
            if(topLine != null){
                topLine.setText(screenInformation.getScreenName());
            }
            if (bottomLine != null) {
                bottomLine.setText(screenInformation.getBottomInformation());                            }

            if(checkBox != null){
                checkBox.setFocusable(false);
                checkBox.setFocusableInTouchMode(false);
                checkBox.setClickable(false);
                checkBox.setChecked(screenInformation.getDone());
            }
        }
        return v;
    }

}
