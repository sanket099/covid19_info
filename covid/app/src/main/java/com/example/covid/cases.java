package com.example.covid;

import android.os.Parcel;
import android.os.Parcelable;

public class cases implements Parcelable {

    private String country_name;
    private String cases;
    private String deaths;
    private  String recovered;


    public cases() {
    }

    public cases(String country_name, String cases, String deaths, String recovered) {
        this.country_name = country_name;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    protected cases(Parcel in) {
        country_name = in.readString();
        cases = in.readString();
        deaths = in.readString();
        recovered = in.readString();
    }

    public static final Creator<cases> CREATOR = new Creator<cases>() {
        @Override
        public cases createFromParcel(Parcel in) {
            return new cases(in);
        }

        @Override
        public cases[] newArray(int size) {
            return new cases[size];
        }
    };

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country_name);
        dest.writeString(cases);
        dest.writeString(deaths);
        dest.writeString(recovered);
    }
}

