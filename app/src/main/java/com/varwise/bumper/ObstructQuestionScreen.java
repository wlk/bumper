package com.varwise.bumper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ObstructQuestionScreen extends Activity  {

    public static String baseKey = "ObstructQuestionScreen";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obstruct);
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());
    }



    public void onYes(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        Intent callEmergency = new Intent(getApplicationContext(), MoveVehiclesScreen.class);
        startActivity(callEmergency);
        finish();
    }

    public void onNo(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        finish();
    }


}

