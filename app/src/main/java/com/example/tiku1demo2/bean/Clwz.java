package com.example.tiku1demo2.bean;

/**
 * Created by Administrator on 2019/2/28 0028.
 */

public class Clwz {
    private int id;
    private String time;
    private String road;
    private String message;
    private String kf;
    private String fk;

    public Clwz() {
    }

    public Clwz(int id, String time, String road, String message, String kf, String fk) {
        this.id = id;
        this.time = time;
        this.road = road;
        this.message = message;
        this.kf = kf;
        this.fk = fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKf() {
        return kf;
    }

    public void setKf(String kf) {
        this.kf = kf;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }
}
