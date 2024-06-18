package edu.patterns.shapes.creator;

import edu.patterns.shapes.exception.InvalidCoordinateException;
import edu.patterns.shapes.model.CubeCoordinate;

public interface CubeCoordinateFactory {
    CubeCoordinate newCubeCoordinate(double x, double y, double z);

    CubeCoordinate[] newCubeCoordinates(double[][] coordinates) throws InvalidCoordinateException;

    CubeCoordinate[] newCoordinates(double[][] coordinates) throws InvalidCoordinateException;

    CubeCoordinate newCoordinate(double x, double y, double z);
}