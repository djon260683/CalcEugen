package ru.eugen.calceugen;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class CustomActivity extends AppCompatActivity implements View.OnClickListener {
    public final String KEY = "key";
    public final String KEY_THEME = "theme";
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_activity);
        initButton();
    }

    private void initButton() {
        Button bApply = findViewById(R.id.bApply);
        bApply.setOnClickListener(this);
        RadioButton b = findViewById(R.id.radioButton);
        RadioButton b2 = findViewById(R.id.radioButton2);
        RadioButton b3 = findViewById(R.id.radioButton3);
        RadioButton b4 = findViewById(R.id.radioButton4);
        RadioButton b5 = findViewById(R.id.radioButton5);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE);
        switch (sharedPreferences.getInt(KEY_THEME, 0)){
            case 0:
                b.setChecked(true);
                break;
            case 1:
                b2.setChecked(true);
                break;
            case 2:
                b3.setChecked(true);
                break;
            case 3:
                b4.setChecked(true);
                break;
            case 4:
                b5.setChecked(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton:
                i = 0;
                break;
            case R.id.radioButton2:
                i = 1;
                break;
            case R.id.radioButton3:
                i = 2;
                break;
            case R.id.radioButton4:
                i = 3;
                break;
            case R.id.radioButton5:
                i = 4;
                break;
            case R.id.bApply:
                SharedPreferences sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(KEY_THEME, i);
                editor.commit();
                finish();
        }
    }
}
