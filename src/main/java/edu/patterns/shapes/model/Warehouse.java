package edu.patterns.shapes.model;

import java.util.*;

public class Warehouse {
    private static final Warehouse INSTANCE = new Warehouse();
    private final Map<Integer, CubeData> cubeDataMap = new HashMap<>();

    private Warehouse() { }

    public static Warehouse getInstance() {
        return INSTANCE;
    }

    public CubeData getCubeData(Integer cubeId) {
        return cubeDataMap.get(cubeId);
    }

    public void updateCubeStats(Integer cubeId, double surfaceArea) {
        CubeData data = new CubeData(surfaceArea);
        cubeDataMap.put(cubeId, data);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("cubeDataMap=" + cubeDataMap)
                .toString();
    }

    public static class CubeData {
        private final double surfaceArea;

        public CubeData(double surfaceArea) {
            this.surfaceArea = surfaceArea;
        }

        public double getSurfaceArea() {
            return surfaceArea;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", CubeData.class.getSimpleName() + "[", "]")
                    .add("surfaceArea=" + surfaceArea)
                    .toString();
        }
    }
}