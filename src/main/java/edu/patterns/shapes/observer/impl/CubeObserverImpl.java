package edu.patterns.shapes.observer.impl;

import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.model.Warehouse;
import edu.patterns.shapes.observer.CubeObserver;
import edu.patterns.shapes.service.CubeService;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class CubeObserverImpl implements CubeObserver {
    private static final Logger logger = Logger.getLogger(CubeObserverImpl.class);
    private static final String LOG_FORMAT = "Cube updated: ID = %d, Surface Area = %.2f, Coordinates = %s";

    private final CubeService service;

    public CubeObserverImpl() {
        this.service = new CubeService();
    }

    @Override
    public void update(Cube cube) {
        double surfaceArea = service.cubeSurfaceArea(cube);
        int cubeId = cube.getId();
        String coordinates = Arrays.toString(cube.getCoordinates());

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.updateCubeStats(cubeId, surfaceArea);

        logger.info(String.format(LOG_FORMAT, cubeId, surfaceArea, coordinates));
    }
}