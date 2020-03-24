package com.example.covid;

public class specific_case {
    private String Country;
    private String Date;
    private String Cases;
    private String Status;

    public specific_case() {
    }

    public specific_case(String country, String date, String cases, String status) {
        Country = country;
        Date = date;
        Cases = cases;
        Status = status;
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
}

