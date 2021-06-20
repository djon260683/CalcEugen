package ru.eugen.calceugen;

import android.os.Parcel;
import android.os.Parcelable;



public class Calculations implements Parcelable {

    private double num1; // число 1
    private double num2; // число 2
    private String sLog; // для хранения loga нажатий пользователя
    private String sView; // для хранения текущей записи
    private String sOperation; // для хранения текущей операции

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getsLog() {
        return sLog;
    }

    public void setsLog(String sLog) {
        this.sLog = sLog;
    }

    public String getsView() {
        return sView;
    }

    public void setsView(String sView) {
        this.sView = sView;
    }

    public Calculations() {
        this.num1 = 0;
        sLog = "";
        sView = "0";
    }
    protected Calculations(Parcel in) {
    }

    public static final Creator<Calculations> CREATOR = new Creator<Calculations>() {
        @Override
        public Calculations createFromParcel(Parcel in) {
            return new Calculations(in);
        }

        @Override
        public Calculations[] newArray(int size) {
            return new Calculations[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
