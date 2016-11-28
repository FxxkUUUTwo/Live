package com.other.project.live.custom;

/**
 * Created by wanghaixin on 16/11/28.
 */
public class MyEventBus {
    public MyEventBus(String city) {
        this.city = city;
    }


    public MyEventBus(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    private String city;

    private double longitude;//经度
    private double latitude;//维度

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
