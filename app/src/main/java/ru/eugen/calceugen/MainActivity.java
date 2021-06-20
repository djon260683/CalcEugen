package ru.eugen.calceugen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String keyCalc = "Calc";
    private Calculations calculations;

    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bReset;
    private Button bTotal;
    private Button bDivision;
    private Button bMultiply;
    private Button bSubtraction;
    private Button bAddition;
    private Button bMinus;
    private Button bPoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();

    }

    private void initButton() {
        b0 = findViewById(R.id.button0);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        bReset = findViewById(R.id.reset);
        bTotal = findViewById(R.id.total);
        bDivision = findViewById(R.id.division);
        bMultiply = findViewById(R.id.multiply);
        bSubtraction = findViewById(R.id.subtraction);
        bAddition = findViewById(R.id.addition);
        bMinus = findViewById(R.id.minus);
        bPoint = findViewById(R.id.point);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(keyCalc, (Serializable) calculations);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculations = (Calculations) instanceState.getSerializable(keyCalc);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                break;
            case R.id.button1:
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.reset:
                break;
            case R.id.total:
                break;
            case R.id.division:
                break;
            case R.id.multiply:
                break;
            case R.id.subtraction:
                break;
            case R.id.addition:
                break;
            case R.id.minus:
                break;
            case R.id.point:
                break;


        }
        ;


    }
}