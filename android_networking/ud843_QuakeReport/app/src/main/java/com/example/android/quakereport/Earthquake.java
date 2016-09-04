package com.example.android.quakereport;

/**
 * Created by Lara on 04/09/2016.
 */
public class Earthquake {

    float magnitude;
    String city;
    String date;

    public Earthquake(float magnitude, String city, String date) {
        this.magnitude = magnitude;
        this.city = city;
        this.date = date;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

}
