package edu.patterns.shapes.creator.impl;

import edu.patterns.shapes.creator.CubeFactory;
import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.model.CubeState;
import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CubeFactoryImpl implements CubeFactory {
    private static final Logger logger = Logger.getLogger(CubeFactoryImpl.class);
    private static final int EXPECTED_COORDINATE_LENGTH = 3;
    private static final int EXPECTED_CUBE_COORDINATES = 8;

    @Override
    public Cube createCube(CubeCoordinate[] coordinates) throws InvalidCubeException {
        return new Cube(coordinates);
    }

    @Override
    public List<Cube> createCubes(List<CubeCoordinate[]> coordinates) throws InvalidCubeException {
        List<Cube> cubes = new ArrayList<>();
        for (CubeCoordinate[] coordinateArray : coordinates) {
            Cube cube = createCube(coordinateArray);
            cubes.add(cube);
        }
        return cubes;
    }

    @Override
    public List<Cube> createCubesFromFile(String filePath) {
        List<Cube> cubes = new ArrayList<>();
        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            logger.error("File does not exist: " + filePath);
            return cubes;
        }

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                try {
                    String[] stringCoordinates = line.split(";");
                    if (stringCoordinates.length == EXPECTED_CUBE_COORDINATES) {
                        CubeCoordinate[] coordinates = parseCoordinates(stringCoordinates);
                        Cube cube = createCube(coordinates);
                        if (cube != null) {
                            if (CubeState.detect(cube) == CubeState.REGULAR) {
                                cubes.add(cube);
                                logger.warn("Regular cube added: " + cube);
                            } else {
                                logger.warn("Cube is not regular, skipping: " + cube);
                            }
                        }
                    } else {
                        logger.error("Invalid number of coordinates in line: " + line);
                    }
                } catch (Exception e) {
                    logger.error("Error parsing line: " + line, e);
                }
            });

        } catch (Exception e) {
            logger.error("Error occurred while reading file: " + filePath, e);
        }
        return cubes;
    }

    private CubeCoordinate[] parseCoordinates(String[] stringCoordinates) {
        CubeCoordinate[] coordinates = new CubeCoordinate[EXPECTED_CUBE_COORDINATES];
        for (int i = 0; i < EXPECTED_CUBE_COORDINATES; i++) {
            String[] xyz = stringCoordinates[i].split(",");
            if (xyz.length == EXPECTED_COORDINATE_LENGTH) {
                try {
                    double x = Double.parseDouble(xyz[0]);
                    double y = Double.parseDouble(xyz[1]);
                    double z = Double.parseDouble(xyz[2]);
                    coordinates[i] = new CubeCoordinate(x, y, z);
                } catch (NumberFormatException e) {
                    logger.error("Error parsing coordinates for line: " + stringCoordinates[i], e);
                }
            } else {
                logger.error("Invalid number of values in coordinate: " + stringCoordinates[i]);
            }
        }
        return coordinates;
    }

    @Override
    public Cube newCube(CubeCoordinate[] coordinates) {
        return null;
    }

    @Override
    public List<Cube> newCubes(List<CubeCoordinate[]> coordinates) {
        return null;
    }

    @Override
    public List<Cube> newCubesFromFile(String filePath) {
        return null;
    }
}