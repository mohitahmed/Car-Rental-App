package com.example.carrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class gallery extends AppCompatActivity {

    ImageView mimage1;
    ImageView mimage2;
    ImageView mimage3;
    ImageView mimage4;
    ImageView mimage5;
    ImageView mimage6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mimage1 = (ImageView) findViewById(R.id.gal1);
        mimage2 = (ImageView) findViewById(R.id.gal2);
        mimage3 = (ImageView) findViewById(R.id.gal3);
        mimage4 = (ImageView) findViewById(R.id.gal4);
        mimage5 = (ImageView) findViewById(R.id.gal5);
        mimage6 = (ImageView) findViewById(R.id.gal6);



        mimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(gallery.this, gallery1.class);
                startActivity(intentLoadNewActivity);


            }
        });
        mimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(gallery.this, gallery2.class);
                startActivity(intentLoadNewActivity);


            }
        });
        mimage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(gallery.this, gallery3.class);
                startActivity(intentLoadNewActivity);


            }
        });

        mimage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(gallery.this, gallery4.class);
                startActivity(intentLoadNewActivity);


            }
        });

        mimage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(gallery.this, gallery5.class);
                startActivity(intentLoadNewActivity);


            }
        });

        mimage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(gallery.this, gallery6.class);
                startActivity(intentLoadNewActivity);


            }
        });



    }
}