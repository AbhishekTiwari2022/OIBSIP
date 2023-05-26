package com.abhimaster.unitconverterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText inputNum;
    Button meter;
    Button centimeter;
    Button gram;
    Button kilogram;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.green));
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        inputNum = findViewById(R.id.editTextNumberDecimal);
        meter = findViewById(R.id.btn_meter);
        centimeter = findViewById(R.id.btn_centimeter);
        gram = findViewById(R.id.btn_grams);
        kilogram = findViewById(R.id.btn_kilograms);
        output = findViewById(R.id.txt_output);

        meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = inputNum.getText().toString();
                int number = Integer.parseInt(num);
                float meter = (number / 100);
                output.setText("Value in centimeter to meter :- " +meter);
            }
        });
        centimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = inputNum.getText().toString();
                int number = Integer.parseInt(num);
                float centimeter = (number * 100);
                output.setText("Value in meter to centimeter :- " +centimeter);
            }
        });
        gram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = inputNum.getText().toString();
                int number = Integer.parseInt(num);
                float gram = (number * 1000);
                output.setText("Value in kilogram to gram :- " +gram);
            }
        });
        kilogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = inputNum.getText().toString();
                int number = Integer.parseInt(num);
                float kilogram = (number/1000);
                output.setText("Value in gram to kilogram :- " +kilogram);
            }
        });
    }
}