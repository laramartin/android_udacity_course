package com.example.android.quakereport;

/**
 * Created by Lara on 04/09/2016.
 */
public class Earthquake {

    double magnitude;
    String location;
    long date;
    String url;

    public Earthquake(double magnitude, String location, Long date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
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

    public String getUrl() {
        return url;
    }
}
