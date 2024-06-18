package edu.patterns.shapes.main;

import edu.patterns.shapes.creator.CubeCoordinateFactory;
import edu.patterns.shapes.creator.impl.CubeCoordinateFactoryImpl;
import edu.patterns.shapes.creator.impl.CubeFactoryImpl;
import edu.patterns.shapes.exception.InvalidCoordinateException;
import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.model.Warehouse;
import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    private static final String CUBES_FILE_PATH = "C:\\Users\\morji\\IdeaProjects\\PatternsTaskOne\\PatternsFirstTask\\src\\main\\resources\\Cubes.txt";

    public static void main(String[] args) {

        try {
            Path filePath = Path.of(CUBES_FILE_PATH);
            if (!Files.exists(filePath)) {
                logger.error("File does not exist: " + CUBES_FILE_PATH);
                System.out.println("File does not exist: " + CUBES_FILE_PATH);
                return;
            }

            CubeCoordinateFactory coordinateFactory = new CubeCoordinateFactoryImpl();
            CubeFactoryImpl cubeFactory = new CubeFactoryImpl();

            List<Cube> cubes = cubeFactory.createCubesFromFile(CUBES_FILE_PATH);

            if (!cubes.isEmpty()) {
                Warehouse warehouse = Warehouse.getInstance();

                for (Cube cube : cubes) {
                    System.out.println(cube);
                    cube.notifyObservers();
                    System.out.println(warehouse);
                }

                double[][] coordinatesArray = {
                        {0, 0, 0},
                        {2, 0, 0},
                        {2, 2, 0},
                        {0, 2, 0},
                        {0, 0, 2},
                        {2, 0, 2},
                        {2, 2, 2},
                        {0, 2, 2}
                };

                CubeCoordinate[] newCoordinates = coordinateFactory.newCoordinates(coordinatesArray);
                for (Cube cube : cubes) {
                    cube.setCoordinates(newCoordinates);
                    System.out.println(warehouse);
                }
            } else {
                System.out.println("No cubes in the file.");
                logger.info("No cubes found in the file.");
            }
        } catch (InvalidCubeException | InvalidCoordinateException e) {
            logger.error("An error occurred while processing cubes.", e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred.", e);
        }
    }
}