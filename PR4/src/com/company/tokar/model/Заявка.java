package com.company.tokar.model;

public class Заявка {

    private String workType;

    private String date;

    private double scale;

    public Заявка() {
    }

    public Заявка(String workType, String date, double scale) {
        this.workType = workType;
        this.date = date;
        this.scale = scale;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Заявка{" +
                "workType='" + workType + '\'' +
                ", date='" + date + '\'' +
                ", scale=" + scale +
                '}';
    }
}
