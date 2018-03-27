package com.annasblackhat.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa2 implements Parcelable {
    private String name;
    private int age;
    private String address;
    private String jurusan;

    protected Mahasiswa2(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
        jurusan = in.readString();
    }

    public Mahasiswa2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static final Creator<Mahasiswa2> CREATOR = new Creator<Mahasiswa2>() {
        @Override
        public Mahasiswa2 createFromParcel(Parcel in) {
            return new Mahasiswa2(in);
        }

        @Override
        public Mahasiswa2[] newArray(int size) {
            return new Mahasiswa2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
        dest.writeString(jurusan);
    }
}
