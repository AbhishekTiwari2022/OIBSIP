package com.abhimaster.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /* Task:3
    * Calculator App BY Abhishek Tiwari */
    String oldNumber;
    String op = "+";
    EditText edtext;
    boolean isanynumberclicked=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtext = findViewById(R.id.editTextText);
    }
    public void numberEvent(View view){
        if(isanynumberclicked){
            edtext.setText("");
        }
        isanynumberclicked=false;
        String number = edtext.getText().toString();
        switch (view.getId()){
            case R.id.bu1 :
                number +="1";
                break;
            case R.id.bu2 :
                number +="2";
                break;
            case R.id.bu3 :
                number +="3";
                break;
            case R.id.bu4 :
                number +="4";
                break;
            case R.id.bu5 :
                number +="5";
                break;
            case R.id.bu6 :
                number +="6";
                break;
            case R.id.bu7 :
                number +="7";
                break;
            case R.id.bu8 :
                number +="8";
                break;
            case R.id.bu9 :
                number +="9";
                break;
            case R.id.bu0 :
                number +="0";
                break;
            case R.id.buDot :
                number +=".";
                break;
            case R.id.buPlusMinus :
                number = "-"+number;
                break;
        }
        edtext.setText(number);
    }
    public void operatorEvent(View view){
        isanynumberclicked=true;
        oldNumber = edtext.getText().toString();
        switch (view.getId()){
            case R.id.buDevide:
                op="/";
                break;
            case R.id.buPlus:
                op="+";
                break;
            case R.id.buMinus:
                op="-";
                break;
            case R.id.buMultiply:
                op="*";
                break;
        }
    }
    public void equalEvent(View view){
        String newNum = edtext.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNum);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNum);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNum);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNum);
                break;
        }
        edtext.setText(result+"");
    }

    public void acEvent(View view){
        edtext.setText("0");
        isanynumberclicked=true;
    }
    public void percentEvent(View view){
        Double n = Double.parseDouble(edtext.getText().toString())/100;
        edtext.setText(n+"");
        isanynumberclicked=true;
    }
}