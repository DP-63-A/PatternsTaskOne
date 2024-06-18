package edu.patterns.shapes.service;

import edu.patterns.shapes.model.Cube;
import org.apache.log4j.Logger;

public class CubeService {
    private static final Logger logger = Logger.getLogger(CubeService.class);

    public double cubeSurfaceArea(Cube cube) {
        double surfaceArea = 6 * Math.pow(cube.getSideLength(), 2);
        logger.info(String.format("Cube %d's surface area is %.2f", cube.getId(), surfaceArea));
        return surfaceArea;
    }
}
