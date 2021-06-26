package ru.eugen.calceugen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    private TextView tView;
    private TextView tLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculations = new Calculations();

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

//        Log.v(TAG, s);
        calculations.setsView(s);
        tView.setText(s);
    }

    private void operEnter(String oper) {
        if (calculations.getsOperation().equals("")) {
            calculations.setNum1(Double.valueOf(tView.getText().toString()));
            tView.setText("0");
            calculations.setsView("0");
        }
        tLog.setText(calculations.getNum1() + oper);
        calculations.setsOperation(oper);
    }
    private void minusEnter(){
        double db =0;
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
}