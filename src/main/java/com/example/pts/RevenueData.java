package com.example.pts;

public class RevenueData {
    private String stationName;
    private String month;
    private double revenue;

    public RevenueData(String stationName, String month, double revenue) {
        this.stationName = stationName;
        this.month = month;
        this.revenue = revenue;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}