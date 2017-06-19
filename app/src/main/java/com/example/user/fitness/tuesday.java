package com.example.user.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class tuesday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
    }
    public void onButtonClick(View v) {

        if (v.getId() == R.id.btdemo4) {
            Intent i = new Intent(tuesday.this, dumbelltricep.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo5) {
            Intent i = new Intent(tuesday.this, seatedbicep.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo6) {
            Intent i = new Intent(tuesday.this, barbellcurl.class);
            startActivity(i);
        }

    }}
