package ru.eugen.calceugen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String keyCalc = "Calc";
    private Calculations calculations;
    public final String TAG = "MyLogger";
    public final String KEY = "key";
    public final String KEY_THEME = "theme";

    private TextView tView;
    private TextView tLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculations = new Calculations();
        initButton();
    }

    @Override
    protected void onStart() {
        getMyTheme();
        super.onStart();
    }

    private void initButton() {
        Button b0 = findViewById(R.id.button0);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        Button b5 = findViewById(R.id.button5);
        Button b6 = findViewById(R.id.button6);
        Button b7 = findViewById(R.id.button7);
        Button b8 = findViewById(R.id.button8);
        Button b9 = findViewById(R.id.button9);
        Button bReset = findViewById(R.id.reset);
        Button bTotal = findViewById(R.id.total);
        Button bDivision = findViewById(R.id.division);
        Button bMultiply = findViewById(R.id.multiply);
        Button bSubtraction = findViewById(R.id.subtraction);
        Button bAddition = findViewById(R.id.addition);
        Button bMinus = findViewById(R.id.minus);
        Button bPoint = findViewById(R.id.point);
        Button bTheme = findViewById(R.id.bTheme);
        tView = findViewById(R.id.textView);
        tLog = findViewById(R.id.textLog);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bReset.setOnClickListener(this);
        bTotal.setOnClickListener(this);
        bDivision.setOnClickListener(this);
        bMultiply.setOnClickListener(this);
        bSubtraction.setOnClickListener(this);
        bAddition.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bPoint.setOnClickListener(this);
        bPoint.setOnClickListener(this);
        bTheme.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyCalc, calculations);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculations = (Calculations) instanceState.getParcelable(keyCalc);
        updateText();
    }

    private void updateText() {
        tLog.setText(calculations.getsLog());
        tView.setText(calculations.getsView());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                numEnter("0");
                break;
            case R.id.button1:
                numEnter("1");
                break;
            case R.id.button2:
                numEnter("2");
                break;
            case R.id.button3:
                numEnter("3");
                break;
            case R.id.button4:
                numEnter("4");
                break;
            case R.id.button5:
                numEnter("5");
                break;
            case R.id.button6:
                numEnter("6");
                break;
            case R.id.button7:
                numEnter("7");
                break;
            case R.id.button8:
                numEnter("8");
                break;
            case R.id.button9:
                numEnter("9");
                break;
            case R.id.reset:
                tView.setText("0");
                tLog.setText("");
                calculations.setsLog("");
                calculations.setsView("0");
                calculations.setsOperation("");
                calculations.setNum1(0);
                calculations.setNum2(0);
                break;
            case R.id.total:
                totalEnter();
                break;
            case R.id.division:
                operEnter("/");
                break;
            case R.id.multiply:
                operEnter("*");
                break;
            case R.id.subtraction:
                operEnter("-");
                break;
            case R.id.addition:
                operEnter("+");
                break;
            case R.id.minus:
                minusEnter();
                break;

            case R.id.point:
                if (calculations.getsView().indexOf('.') == -1) {
                    numEnter(".");
                }
                break;
            case R.id.bTheme:
                Intent intent = new Intent(this, CustomActivity.class);
                this.startActivity(intent);
                break;
        }
        ;
    }

    private void numEnter(String num) {
        String s = "";
        if (calculations.getsView().equals("0")) {
            s = num;
        } else {
            s = calculations.getsView() + num;
        }
        ;
        calculations.setsView(s);
        tView.setText(s);
    }

    private void operEnter(String oper) {
        if (calculations.getsOperation().equals("")) {
            calculations.setNum1(Double.valueOf(tView.getText().toString()));
            tView.setText("0");
            calculations.setsView("0");
        }
        tLog.setText(String.format("%s%s", calculations.getNum1(), oper));
        calculations.setsOperation(oper);
    }

    private void minusEnter() {
        double db = 0;
        db = Double.valueOf(tView.getText().toString());
        db = -1 * db;
        tView.setText(String.valueOf(db));
    }

    private void totalEnter() {
        if (calculations.getsOperation().equals("")) return;
        calculations.setNum2(Double.valueOf(tView.getText().toString()));
        if (calculations.getNum2() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "На ноль делить нельзя!!!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
        double calc = 0;
        switch (calculations.getsOperation()) {
            case "+":
                calc = calculations.getNum1() + calculations.getNum2();
                break;
            case "-":
                calc = calculations.getNum1() - calculations.getNum2();
                break;
            case "*":
                calc = calculations.getNum1() * calculations.getNum2();
                break;
            case "/":
                calc = calculations.getNum1() / calculations.getNum2();
                break;
        }
        tView.setText(String.valueOf(calc));
        calculations.setsView(String.valueOf(calc));
        tLog.setText("");
        calculations.setsLog("");
        calculations.setsOperation("");
        calculations.setNum1(0);
        calculations.setNum2(0);
    }

    private void getMyTheme(){
        int i = R.color.standart;
        SharedPreferences sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE);
        switch (sharedPreferences.getInt(KEY_THEME, i)){
            case 0:
                i = R.color.standart;
                break;
            case 1:
                i = R.color.red;
                break;
            case 2:
                i = R.color.yellow;
                break;
            case 3:
                i = R.color.green;
                break;
            case 4:
                i = R.color.unusual;
                break;
        }
        tView.setBackgroundResource(i);
        tLog.setBackgroundResource(i);
    }
}