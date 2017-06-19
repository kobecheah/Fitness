package com.example.user.fitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class bmiCal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_cal);



        final Button button_calc =(Button) findViewById(R.id.button_calc);
        final EditText field_weight= (EditText) findViewById(R.id.field_weight);
        final  EditText field_height=(EditText) findViewById(R.id.field_height);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);

        button_calc.setOnClickListener  (new View.OnClickListener(){

            @Override
            public void onClick(View v){

                double weight;
                double height;
                double bmi;
                String msg="";

                if(field_height.getText().toString().equals("")|| field_weight.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "No valid values!" , Toast.LENGTH_LONG);

                }else{


                    weight = Double.parseDouble(field_weight.getText().toString());
                    height = Double.parseDouble(field_height.getText().toString());



                    bmi = height * height ;
                    bmi = weight / bmi;

                    view_result.setText(String.valueOf(bmi));
                    if(bmi < 18.5){
                        msg = "Underweight :( ";
                    }
                    else if (bmi > 18.5 && bmi <25 ){
                        msg ="Normal :)";

                    }

                    else if (bmi > 25){
                        msg ="Overweight";
                    }

                    view_msg.setText(msg);

                }

            }

        });}}