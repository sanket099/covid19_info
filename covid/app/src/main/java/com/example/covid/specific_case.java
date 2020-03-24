package com.example.covid;

import android.view.LayoutInflater;

public class specific_case {
    private String Country;
    private String Date;
    private String Cases;
    private String Status;
    private Double Lat;
    private Double Lon;

    public specific_case() {
    }

    public specific_case(String country, String date, String cases, String status, Double lat, Double longi) {
        Country = country;
        Date = date;
        Cases = cases;
        Status = status;
        this.Lat = lat;
        this.Lon = longi;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCases() {
        return Cases;
    }

    public void setCases(String cases) {
        Cases = cases;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        this.Lat = lat;
    }

    public Double getLongi() {
        return Lon;
    }

    public void setLongi(Double longi) {
        this.Lon = longi;
    }
}

