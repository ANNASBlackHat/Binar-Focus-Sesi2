package com.annasblackhat.myapplication;

import java.io.Serializable;

public class Mahasiswa implements Serializable {
    private String name;
    private int age;
    private String address;
    private Jurusan jurusan;

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
}
