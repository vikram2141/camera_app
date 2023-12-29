package com.example.camera_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    private final int CAMERA_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btncamera);
        img = findViewById(R.id.image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in, CAMERA_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (requestCode == CAMERA_REQ_CODE) {
                Bitmap im = (Bitmap) (data.getExtras().get("data"));
                img.setImageBitmap(im);
            }
        }
    }

}