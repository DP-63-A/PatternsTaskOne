package edu.patterns.shapes.creator.impl;

import edu.patterns.shapes.creator.CubeCoordinateFactory;
import edu.patterns.shapes.exception.InvalidCoordinateException;
import edu.patterns.shapes.model.CubeCoordinate;
import org.apache.log4j.Logger;

public class CubeCoordinateFactoryImpl implements CubeCoordinateFactory {
    private static final Logger logger = Logger.getLogger(CubeCoordinateFactoryImpl.class);

    @Override
    public CubeCoordinate newCubeCoordinate(double x, double y, double z) {
        return new CubeCoordinate(x, y, z);
    }

    @Override
    public CubeCoordinate[] newCubeCoordinates(double[][] coordinates) throws InvalidCoordinateException {
        CubeCoordinate[] coordinateArray = new CubeCoordinate[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            double[] coordinate = coordinates[i];
            if (coordinate.length != 3) {
                logger.warn("There are " + coordinate.length + " values instead of 3 in coordinate №" + i);
                throw new InvalidCoordinateException("A coordinate must contain x, y, z");
            } else {
                coordinateArray[i] = newCubeCoordinate(coordinate[0], coordinate[1], coordinate[2]);
            }
        }
        logger.info("New cube coordinates created successfully.");
        return coordinateArray;
    }

    @Override
    public CubeCoordinate[] newCoordinates(double[][] coordinates) throws InvalidCoordinateException {
        return newCubeCoordinates(coordinates);
    }

    @Override
    public CubeCoordinate newCoordinate(double x, double y, double z) {
        return new CubeCoordinate(x, y, z);
    }
}