package com.varwise.bumper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;


public class InsuranceScreen extends Activity     {
    public static String baseKey = "InsuranceScreen";
    Spinner spinner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roadsite_assistance);
    }

    public void callInsurence(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        Toast.makeText(getApplicationContext(), "Please wait, calling... ", Toast.LENGTH_LONG).show();
    }


    public void onNo(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        finish();
    }

}

