package com.example.tiku1demo2.bean;

public class HldInfor {
    int id;
    int red;
    int green;
    int yellow;

    public HldInfor() {
    }

    public HldInfor(int id, int red, int green, int yellow) {
        this.id = id;
        this.red = red;
        this.green = green;
        this.yellow = yellow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }
}
