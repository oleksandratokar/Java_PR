package com.company.tokar.model;

public class Dot {
    private int x;

    private int y;

    private double distanceSum;

    public Dot() {
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistanceSum() {
        return distanceSum;
    }

    public void setDistanceSum(double distanceSum) {
        this.distanceSum = distanceSum;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", distanceSum=" + distanceSum +
                '}';
    }
}
