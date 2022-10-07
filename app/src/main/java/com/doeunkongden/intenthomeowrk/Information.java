package com.doeunkongden.intenthomeowrk;

import java.io.Serializable;

public class Information implements Serializable {
    String name;
    String date;
    String gender;
    String city;

    public Information(String name, String date, String gender, String city) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
