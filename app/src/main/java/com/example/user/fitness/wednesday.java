package com.example.user.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class wednesday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);
    }
    public void onButtonClick(View v) {

        if (v.getId() == R.id.btdemo7) {
            Intent i = new Intent(wednesday.this, deadlift.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo8) {
            Intent i = new Intent(wednesday.this, shoulderpress.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btdemo9) {
            Intent i = new Intent(wednesday.this, cablerow.class);
            startActivity(i);
        }
    }
}
