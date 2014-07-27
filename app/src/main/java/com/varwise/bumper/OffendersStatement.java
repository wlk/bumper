package com.varwise.bumper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class OffendersStatement extends Activity {
    public static String baseKey = "OffendersStatement";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offenders_statement);
    }

    public void sendEmail(View v) {
        ScreenDB.setFinishedDate(baseKey, getApplicationContext());

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Offender's Statement");

        String rawFolderPath = "android.resource://" + getPackageName() + "/" + R.raw.oswiadczenie;

        Uri emailUri = Uri.parse(rawFolderPath );
        emailIntent.putExtra(Intent.EXTRA_STREAM, emailUri);

        startActivity(Intent.createChooser(emailIntent, "Offender's Statement"));
    }
}
