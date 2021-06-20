package ru.eugen.calceugen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String keyCalc = "Calc";
    private Calculations calculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
}