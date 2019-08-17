package com.example.tareaeva1.objects;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class Rol implements Parcelable {
    private int rol;
    private ArrayList<Characters> characters;
    private String rolName;

    public Rol(int imageRol, ArrayList<Characters> characters, String rolName) {
        this.rol = imageRol;
        this.characters = characters;
        this.rolName = rolName;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public ArrayList<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Characters> characters) {
        this.characters = characters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.rol);
        dest.writeTypedList(this.characters);
        dest.writeString(this.rolName);
    }

    protected Rol(Parcel in) {
        this.rol = in.readInt();
        this.characters = in.createTypedArrayList(Characters.CREATOR);
        this.rolName = in.readString();
    }

    public static final Creator<Rol> CREATOR = new Creator<Rol>() {
        @Override
        public Rol createFromParcel(Parcel source) {
            return new Rol(source);
        }

        @Override
        public Rol[] newArray(int size) {
            return new Rol[size];
        }
    };
}
