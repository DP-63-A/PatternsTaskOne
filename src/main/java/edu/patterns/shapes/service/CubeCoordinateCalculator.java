package edu.patterns.shapes.service;

import edu.patterns.shapes.model.CubeCoordinate;

public class CubeCoordinateCalculator {
    public static double distanceOfCoordinates(CubeCoordinate coordinate1, CubeCoordinate coordinate2) {
        double xDifference = coordinate2.getX() - coordinate1.getX();
        double yDifference = coordinate2.getY() - coordinate1.getY();
        double zDifference = coordinate2.getZ() - coordinate1.getZ();

        return Math.sqrt(xDifference * xDifference + yDifference * yDifference + zDifference * zDifference);
    }
}
