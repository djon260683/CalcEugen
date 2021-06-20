package ru.eugen.calceugen;

import android.os.Parcel;
import android.os.Parcelable;



public class Calculations implements Parcelable {

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
