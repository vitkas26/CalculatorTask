package com.example.calculatortask.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class SavedTextBundle implements Parcelable {
    private String savedResultText;
    public SavedTextBundle() {

    }

    public String getSavedResultText() {
        return savedResultText;
    }

    public void setSavedResultText(String savedResultText) {
        this.savedResultText = savedResultText;
    }


    public SavedTextBundle(Parcel in) {
        savedResultText = in.readString();
    }

    public static final Creator<SavedTextBundle> CREATOR = new Creator<SavedTextBundle>() {
        @Override
        public SavedTextBundle createFromParcel(Parcel in) {
            return new SavedTextBundle(in);
        }

        @Override
        public SavedTextBundle[] newArray(int size) {
            return new SavedTextBundle[size];
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
