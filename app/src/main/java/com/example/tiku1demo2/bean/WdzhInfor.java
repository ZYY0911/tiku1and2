package com.example.tiku1demo2.bean;

public class WdzhInfor {
    private String carnumber;
    private String jine;
    private String name;
    private String time;

    public WdzhInfor(String carnumber, String jine, String name, String time) {
        this.carnumber = carnumber;
        this.jine = jine;
        this.name = name;
        this.time = time;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getJine() {
        return jine;
    }

    public void setJine(String jine) {
        this.jine = jine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
