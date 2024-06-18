package edu.patterns.shapes.model;

import edu.patterns.shapes.creator.impl.CubeCoordinateFactoryImpl;
import edu.patterns.shapes.exception.InvalidCoordinateException;
import edu.patterns.shapes.exception.InvalidCubeException;
import org.apache.log4j.Logger;

import java.util.*;

import static edu.patterns.shapes.service.CubeCoordinateCalculator.distanceOfCoordinates;

public enum CubeState {
    REGULAR, INVALID;

    private static final Logger LOGGER = Logger.getLogger(CubeState.class);

    public static CubeState detect(CubeCoordinate[] coordinates) throws InvalidCubeException {
        if (!isValidCube(coordinates)) {
            LOGGER.warn("Detection failed: invalid cube structure.");
            return CubeState.INVALID;
        }

        if (!isValidCube(coordinates)) {
            throw new InvalidCubeException("Cube is invalid");
        }

        if (isRegularCube(coordinates)) {
            LOGGER.info("Cube is detected as REGULAR.");
            return CubeState.REGULAR;
        } else {
            LOGGER.warn("Cube is detected as INVALID.");
            return CubeState.INVALID;
        }
    }

    public static CubeState detect(double[][] coordinates) throws InvalidCubeException, InvalidCoordinateException {
        CubeCoordinateFactoryImpl coordinateFactory = new CubeCoordinateFactoryImpl();
        CubeCoordinate[] cubeCoordinates = coordinateFactory.newCoordinates(coordinates);
        return detect(cubeCoordinates);
    }

    public static CubeState detect(Cube cube) throws InvalidCubeException {
        if (cube == null) {
            LOGGER.error("Cube object is null");
            return CubeState.INVALID;
        }
        CubeState state = detect(cube.getCoordinates());
        logCubeState(cube.getId(), state);
        return state;
    }

    private static boolean isValidCube(CubeCoordinate[] coordinates) {
        if (coordinates == null) {
            LOGGER.error("The array of coordinates is null.");
            return false;
        }
        if (coordinates.length != 8) {
            LOGGER.error("Invalid number of coordinates for a cube: " + coordinates.length);
            return false;
        }
        LOGGER.info("The cube has a valid set of coordinates.");
        return true;
    }

    private static boolean isRegularCube(CubeCoordinate[] coordinates) {
        Map<Double, Integer> distanceCounts = new HashMap<>();
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                double distance = distanceOfCoordinates(coordinates[i], coordinates[j]);
                distanceCounts.put(distance, distanceCounts.getOrDefault(distance, 0) + 1);
            }
        }

        if (distanceCounts.size() == 3) {
            List<Integer> requiredCounts = Arrays.asList(12, 12, 4);
            Collection<Integer> actualCounts = distanceCounts.values();
            if (actualCounts.containsAll(requiredCounts)) {
                return true;
            } else {
                LOGGER.warn("Distance counts do not meet the expected values for a regular cube.");
            }
        } else {
            LOGGER.debug("Cube has " + distanceCounts.size() + " unique distances instead of 3.");
        }
        return false;
    }

    private static void logCubeState(int cubeId, CubeState state) {
        LOGGER.warn("Cube №" + cubeId + (state == CubeState.REGULAR ? " is regular" : " is invalid"));
    }
}