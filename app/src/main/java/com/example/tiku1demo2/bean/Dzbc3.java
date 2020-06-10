package com.example.tiku1demo2.bean;

/**
 * Created by Administrator on 2019/9/18 0018.
 */

public class Dzbc3 {
    private String Yal;
    private String Yil;
    private int ba=0;

    public Dzbc3() {
    }

    public Dzbc3(String yal, String yil, int ba) {
        Yal = yal;
        Yil = yil;
        this.ba = ba;
    }

    public String getYal() {
        return Yal;
    }

    public void setYal(String yal) {
        Yal = yal;
    }

    public String getYil() {
        return Yil;
    }

    public void setYil(String yil) {
        Yil = yil;
    }

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
    }
}
