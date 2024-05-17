package edu.patterns.shapes.model;

import edu.patterns.shapes.util.IdGenerator;

public class Rectangle {
    private int rectangleId;
    private double sideA;
    private double sideB;
    private double sideC;
    private double sideD;
    private RectangleState state = RectangleState.INVALID;

    public Rectangle(double sideA, double sideB, double sideC, double sideD) {
        rectangleId = IdGenerator.increment();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getSideD() {
        return sideD;
    }

    public void setSideD(double sideD) {
        this.sideD = sideD;
    }

    public RectangleState getState() {
        return state;
    }

    public void setState(RectangleState state) {
        if (state != null) {
            this.state = state;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (rectangleId != rectangle.rectangleId) return false;
        if (Double.compare(sideA, rectangle.sideA) != 0) return false;
        if (Double.compare(sideB, rectangle.sideB) != 0) return false;
        if (Double.compare(sideC, rectangle.sideC) != 0) return false;
        if (Double.compare(sideD, rectangle.sideD) != 0) return false;
        return state == rectangle.state;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = rectangleId;
        temp = Double.doubleToLongBits(sideA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "rectangleId=" + rectangleId +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", sideD=" + sideD +
                ", state=" + state +
                '}';
    }
}
