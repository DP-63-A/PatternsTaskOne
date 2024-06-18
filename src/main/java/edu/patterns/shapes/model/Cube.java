package edu.patterns.shapes.model;

import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.observer.CubeObserver;
import edu.patterns.shapes.observer.Observable;
import edu.patterns.shapes.observer.impl.CubeObserverImpl;
import edu.patterns.shapes.service.CubeCoordinateService;
import edu.patterns.shapes.service.CubeCoordinateSorter;
import edu.patterns.shapes.util.IdGenerator;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

public class Cube implements Observable {
    private static final Logger logger = Logger.getLogger(Cube.class);

    private CubeCoordinate[] coordinates;
    private CubeObserver observer;
    private int id;
    private CubeState state;

    public Cube(CubeCoordinate[] coordinates) throws InvalidCubeException {
        validateCoordinates(coordinates);
        this.coordinates = CubeCoordinateSorter.sortCoordinates(coordinates);
        this.id = IdGenerator.increment();
        this.state = CubeState.detect(this);
        this.observer = new CubeObserverImpl();
        logger.info("Cube with id " + id + " and coordinates " + Arrays.toString(coordinates) + " is created");
    }

    private void validateCoordinates(CubeCoordinate[] coordinates) {
        if (coordinates.length != 8) {
            throw new IllegalArgumentException("A cube must have 8 coordinates");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyObservers();
        logger.info("Id of cube with id " + id + " is changed");
    }

    public CubeCoordinate[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CubeCoordinate[] coordinates) throws InvalidCubeException {
        validateCoordinates(coordinates);
        this.coordinates = CubeCoordinateSorter.sortCoordinates(coordinates);
        this.state = CubeState.detect(this);
        notifyObservers();
    }

    public CubeState getState() {
        return state;
    }

    public double getSideLength() {
        return CubeCoordinateService.findVector(coordinates[0], coordinates[1]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cube cube = (Cube) obj;
        return Arrays.equals(coordinates, cube.coordinates);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("coordinates=" + Arrays.toString(coordinates))
                .add("state=" + state)
                .toString();
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(coordinates);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public void attach() {
        observer = new CubeObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }
}