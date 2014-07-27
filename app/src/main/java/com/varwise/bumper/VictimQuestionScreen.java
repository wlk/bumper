package com.varwise.bumper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VictimQuestionScreen extends Activity     {
    public static String baseKey = "VictimQuestionScreen";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victim_question);
    }

    public void onYes(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        Intent callEmergency = new Intent(getApplicationContext(), EmergencyCallScreen.class);
        startActivity(callEmergency);
    }

    public void onNo(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        finish();
    }

}

