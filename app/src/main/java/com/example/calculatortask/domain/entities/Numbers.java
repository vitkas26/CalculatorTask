package com.example.calculatortask.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Numbers implements Parcelable {
    private String lastValue;

    public Numbers(String lastValue) {
        this.lastValue = lastValue;
    }

    public Numbers() {
    }

    public void setLastValue(String lastValue) {
        this.lastValue = lastValue;
    }

    public String getLastValue() {
        return lastValue;
    }

    protected Numbers(Parcel in) {
        lastValue = in.readString();
    }

    public static final Creator<Numbers> CREATOR = new Creator<Numbers>() {
        @Override
        public Numbers createFromParcel(Parcel in) {
            return new Numbers(in);
        }

        @Override
        public Numbers[] newArray(int size) {
            return new Numbers[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(lastValue);
    }
}
