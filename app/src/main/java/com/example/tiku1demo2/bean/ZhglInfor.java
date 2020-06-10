package com.example.tiku1demo2.bean;

public class ZhglInfor {
    private int id;
    private  String pinpai;
    private String carnumber;
    private String name;
    private String yue;
    private boolean ischeck;
    private int min;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public ZhglInfor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYue() {
        return yue;
    }

    public void setYue(String yue) {
        this.yue = yue;
    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public ZhglInfor(int id, String pinpai, String carnumber, String name, String yue, boolean ischeck, int min) {
        this.id = id;
        this.pinpai = pinpai;
        this.carnumber = carnumber;
        this.name = name;
        this.yue = yue;
        this.ischeck = ischeck;
        this.min=min;
    }
}
