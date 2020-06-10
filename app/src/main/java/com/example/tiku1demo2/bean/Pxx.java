package com.example.tiku1demo2.bean;

/**
 * Created by Administrator on 2019/3/3 0003.
 */

public class Pxx {
    int index;
    String Nr;

    public Pxx() {
    }

    public Pxx(int index, String nr) {
        this.index = index;
        Nr = nr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNr() {
        return Nr;
    }

    public void setNr(String nr) {
        Nr = nr;
    }
}
