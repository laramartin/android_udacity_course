package com.example.android.quakereport;

/**
 * Created by Lara on 04/09/2016.
 */
public class Earthquake {

    String magnitude;
    String location;
    Long date;

    public Earthquake(String magnitude, String location, Long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }



}
