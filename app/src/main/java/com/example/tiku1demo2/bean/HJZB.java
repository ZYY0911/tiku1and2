package com.example.tiku1demo2.bean;

/**
 * "temperature": 34,
 *     "humidity": 8,
 *     "illumination": 2657,
 *     "co2": 3935,
 *     "pm25": 72
 * Create by 张瀛煜 on 2019-09-18
 */
public class HJZB {
    private int temperature,humidity,illumination,co2,pm25,dlzt;
    private String ti;

    public HJZB(int temperature, int humidity, int illumination, int co2, int pm25, int dlzt,String ti) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.illumination = illumination;
        this.co2 = co2;
        this.pm25 = pm25;
        this.dlzt = dlzt;
        this.ti = ti;
    }

    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti;
    }

    public int getDlzt() {
        return dlzt;
    }

    public void setDlzt(int dlzt) {
        this.dlzt = dlzt;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getIllumination() {
        return illumination;
    }

    public void setIllumination(int illumination) {
        this.illumination = illumination;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }
}
