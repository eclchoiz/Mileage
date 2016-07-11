package com.choiz.apps.mileage;

import java.util.Date;

/**
 * Created by SSENG on 2016-07-08.
 */
public class MileageDTO {

    private String date;
    private String money;
    private String price;
    private String gas;
    private String distance;

    public MileageDTO() {
    }

    public MileageDTO(String date, String money, String price, String gas, String distance) {
        this.date = date;
        this.money = money;
        this.price = price;
        this.gas = gas;
        this.distance = distance;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
                ", price='" + price + '\'' +
                ", gas='" + gas + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
