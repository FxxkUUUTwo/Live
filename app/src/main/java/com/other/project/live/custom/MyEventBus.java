package com.other.project.live.custom;

/**
 * Created by wanghaixin on 16/11/28.
 */
public class MyEventBus {
    public MyEventBus(String city) {
        this.city = city;
    }

    private String city;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
