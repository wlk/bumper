package com.varwise.bumper;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rembam on 12.07.14.
 */
public class AccidentInformationAdapter extends ArrayAdapter<AccidentInformation> {

    private ArrayList<AccidentInformation> items;
    private int textViewResourceId;
    public AccidentInformationAdapter(Context context, int textViewResourceId, ArrayList<AccidentInformation> items) {
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

        AccidentInformation accidentInformation = items.get(position);

        if (accidentInformation != null) {
            TextView numberTV = (TextView) layout.findViewById(R.id.numer233322);
            TextView line = (TextView) layout.findViewById(R.id.line);

            if (numberTV != null) {
                if(accidentInformation.getNumber()== -1) {
                    numberTV.setText("");
                }
                else{
                    numberTV.setText(ordinal(accidentInformation.getNumber()));

                }
            }

            if (line != null) {
                if (accidentInformation.getNumber() == -1) {
                    line.setTextColor(Color.GRAY);
                    line.setText("Click to add new accident...");
                } else {
                    line.setText(accidentInformation.getDateSimpleFormat());
                }
            }

        }
        return v;
    }

    public static String ordinal(int i) {
        String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + sufixes[i % 10];

        }
    }

}
