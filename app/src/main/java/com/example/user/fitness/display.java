package com.example.user.fitness;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.bt2) {
            Intent i = new Intent(display.this, daily.class);
            startActivity(i);
        }
        if (v.getId() == R.id.bt3) {
            Intent i = new Intent(display.this, bmiCal.class);
            startActivity(i);
        }
        if (v.getId() == R.id.bt4) {
            Intent i = new Intent(display.this, stopwatch.class);
            startActivity(i);
        }
        if (v.getId() == R.id.bt5) {
            Intent i = new Intent(display.this, weightmanaged.class);
            startActivity(i);
        }
        if (v.getId() == R.id.bt6) {
            Intent i = new Intent(display.this, stepcounter.class);
            startActivity(i);
        }
    }
}