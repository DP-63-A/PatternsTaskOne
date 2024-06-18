package edu.patterns.shapes.model;

public class CubeCoordinate {
    private double x;
    private double y;
    private double z;

    public CubeCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CubeCoordinate() { }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distanceTo(CubeCoordinate other) {
        double xDifference = other.getX() - this.x;
        double yDifference = other.getY() - this.y;
        double zDifference = other.getZ() - this.z;
        return Math.sqrt(xDifference * xDifference + yDifference * yDifference + zDifference * zDifference);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CubeCoordinate cubeCoordinate = (CubeCoordinate) obj;
        return Double.compare(cubeCoordinate.x, x) == 0 &&
                Double.compare(cubeCoordinate.y, y) == 0 &&
                Double.compare(cubeCoordinate.z, z) == 0;
    }

    @Override
    public String toString() {
        return String.format("{x=%.2f, y=%.2f, z=%.2f}", x, y, z);
    }
}