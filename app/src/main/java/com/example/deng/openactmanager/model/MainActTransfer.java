package com.example.deng.openactmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by deng on 2016/10/19.
 */

public class MainActTransfer implements Parcelable {

    public int id;
    public String name;
    public ArrayList<String> data;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeStringList(this.data);
    }

    public MainActTransfer() {
    }

    public MainActTransfer(int id, String name, ArrayList<String> data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    protected MainActTransfer(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.data = in.createStringArrayList();
    }

    public static final Parcelable.Creator<MainActTransfer> CREATOR = new Parcelable.Creator<MainActTransfer>() {
        @Override
        public MainActTransfer createFromParcel(Parcel source) {
            return new MainActTransfer(source);
        }

        @Override
        public MainActTransfer[] newArray(int size) {
            return new MainActTransfer[size];
        }
    };
}
