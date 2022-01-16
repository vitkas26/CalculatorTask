package com.example.calculatortask.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class ValuesToCalculate implements Parcelable {
    private String savedResultText;
    public ValuesToCalculate() {

    }

    public String getSavedResultText() {
        return savedResultText;
    }

    public void setSavedResultText(String savedResultText) {
        this.savedResultText = savedResultText;
    }


    public ValuesToCalculate(Parcel in) {
        savedResultText = in.readString();
    }

    public static final Creator<ValuesToCalculate> CREATOR = new Creator<ValuesToCalculate>() {
        @Override
        public ValuesToCalculate createFromParcel(Parcel in) {
            return new ValuesToCalculate(in);
        }

        @Override
        public ValuesToCalculate[] newArray(int size) {
            return new ValuesToCalculate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(savedResultText);
    }
}
