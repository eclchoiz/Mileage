package com.choiz.apps.mileage;

import java.util.Date;

/**
 * Created by SSENG on 2016-07-08.
 */
public class MileageDTO {

    private String date;
    private String money;
    private String litre;
    private String gas;
    private String distance;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getLitre() {
        return litre;
    }

    public void setLitre(String litre) {
        this.litre = litre;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "MileageDTO{" +
                "date=" + date +
                ", money='" + money + '\'' +
                ", litre='" + litre + '\'' +
                ", gas='" + gas + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
