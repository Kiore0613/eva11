package com.example.tareaeva1.objects;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Photo implements Parcelable {
    Bitmap photo;

    public Photo(Bitmap photo) {
        this.photo = photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.photo, flags);
    }

    protected Photo(Parcel in) {
        this.photo = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}
