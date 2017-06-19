package com.example.user.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class monday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.btdemo1) {
            Intent i = new Intent(monday.this, dumbellpress.class);
            startActivity(i);
        }

        if (v.getId() == R.id.btdemo2) {
            Intent i = new Intent(monday.this, smithmachine.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo3) {
            Intent i = new Intent(monday.this, declinepush.class);
            startActivity(i);
        }
}}
