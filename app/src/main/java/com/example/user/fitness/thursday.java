package com.example.user.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class thursday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
    }
    public void onButtonClick(View v) {

        if (v.getId() == R.id.btdemo10) {
            Intent i = new Intent(thursday.this, barbellsquat.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo11) {
            Intent i = new Intent(thursday.this, legpress.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo12) {
            Intent i = new Intent(thursday.this, seatedlegcurl.class);
            startActivity(i);
        }
}
    }