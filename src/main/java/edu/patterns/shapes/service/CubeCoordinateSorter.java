package edu.patterns.shapes.service;

import edu.patterns.shapes.model.CubeCoordinate;

import java.util.Arrays;
import java.util.Comparator;

public class CubeCoordinateSorter {
    public static CubeCoordinate[] sortCoordinates(CubeCoordinate[] cubeCoordinates) {
        CubeCoordinate[] sortedCoordinates = Arrays.stream(cubeCoordinates)
                .sorted(Comparator.comparingDouble(CubeCoordinate::getX)
                        .thenComparingDouble(CubeCoordinate::getY)
                        .thenComparingDouble(CubeCoordinate::getZ))
                .toArray(CubeCoordinate[]::new);
        return sortedCoordinates;
    }
}
