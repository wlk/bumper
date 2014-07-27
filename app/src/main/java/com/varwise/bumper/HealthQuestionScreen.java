package com.varwise.bumper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HealthQuestionScreen extends Activity  {

    public static String baseKey = "HealthQuestionScreen";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_question);
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());
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

