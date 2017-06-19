package com.example.user.fitness;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class daily extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.button) {
            Intent i = new Intent(daily.this,monday.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button2) {
            Intent i = new Intent(daily.this, tuesday.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button3) {
            Intent i = new Intent(daily.this, wednesday.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button4) {
            Intent i = new Intent(daily.this, thursday.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button5) {
            Intent i = new Intent(daily.this, friday.class);
            startActivity(i);
        }

}}
