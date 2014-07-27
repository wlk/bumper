package com.varwise.bumper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rembam on 13.07.14.
 */
public class MoveVehiclesScreen extends Activity {

    public static String baseKey = "MoveVehiclesScreen";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.move_vehicles);
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());
    }



    public void done(View v) {
        finish();
    }


}
