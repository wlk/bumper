package com.varwise.bumper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by pawel on 13.07.14.
 */
public class PhotoViewFullScreen extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_full_view);

        Bundle bundle = getIntent().getExtras();

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int position = bundle.getInt("position");
        imageView.setImageURI(Uri.fromFile(PhotoViewScreen.listFile[position]));
        imageView.setRotation(90);

    }
}
