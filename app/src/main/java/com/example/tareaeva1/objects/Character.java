package com.example.tareaeva1.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {
    private String name;
    private int imageChampion;
    private String info;

    public Character(String name, int imageChampion, String info) {
        this.name = name;
        this.imageChampion = imageChampion;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageChampion() {
        return imageChampion;
    }

    public void setImageChampion(int imageChampion) {
        this.imageChampion = imageChampion;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.imageChampion);
        dest.writeString(this.info);
    }

    protected Character(Parcel in) {
        this.name = in.readString();
        this.imageChampion = in.readInt();
        this.info = in.readString();
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel source) {
            return new Character(source);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };
}
