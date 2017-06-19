package com.example.user.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class friday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.btdemo13) {
            Intent i = new Intent(friday.this, situp.class);
            startActivity(i);
        }

        if (v.getId() == R.id.btdemo14) {
            Intent i = new Intent(friday.this, cablelift.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo15) {
            Intent i = new Intent(friday.this, bicyclecrunch.class);
            startActivity(i);
        }
    }
}