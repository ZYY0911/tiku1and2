package com.example.tiku1demo2.bean;

public class TqInfor {
    private String date;
    private String weather;
    private String wd;

    public TqInfor(String date, String weather, String wd) {
        this.date = date;
        this.weather = weather;
        this.wd = wd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }
}
