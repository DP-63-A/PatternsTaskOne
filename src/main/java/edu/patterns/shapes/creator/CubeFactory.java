package edu.patterns.shapes.creator;

import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.model.Cube;

import java.util.List;

public interface CubeFactory {

    Cube createCube(CubeCoordinate[] coordinates) throws InvalidCubeException;

    List<Cube> createCubes(List<CubeCoordinate[]> coordinates) throws InvalidCubeException;

    List<Cube> createCubesFromFile(String filePath);

    Cube newCube(CubeCoordinate[] coordinates);

    List<Cube> newCubes(List<CubeCoordinate[]> coordinates);
    List<Cube> newCubesFromFile(String filePath);

}