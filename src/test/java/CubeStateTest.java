import static org.junit.Assert.*;

import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.exception.InvalidCoordinateException;
import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.model.CubeState;
import org.junit.Test;
import edu.patterns.shapes.creator.impl.CubeFactoryImpl;

import java.util.List;

public class CubeStateTest {

    private String validCubesFilePath = "src/test/resources/validCubes.txt";
    private String invalidCubesFilePath = "src/test/resources/invalidCubes.txt";

    @Test
    public void testDetect_CubeCoordinateArray_ValidCube() throws InvalidCubeException, InvalidCoordinateException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.REGULAR, CubeState.detect(cube.getCoordinates()));
        }
    }

    @Test
    public void testDetect_CubeCoordinateArray_InvalidCube() throws InvalidCubeException, InvalidCoordinateException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(invalidCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.INVALID, CubeState.detect(cube.getCoordinates()));
        }
    }

    @Test
    public void testDetect_DoubleArray_ValidCube() throws InvalidCubeException, InvalidCoordinateException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.REGULAR, CubeState.detect(cube.getCoordinates()));
        }
    }

    @Test
    public void testDetect_DoubleArray_InvalidCube() throws InvalidCubeException, InvalidCoordinateException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(invalidCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.INVALID, CubeState.detect(cube.getCoordinates()));
        }
    }

    @Test
    public void testDetect_Cube_ValidCube() throws InvalidCubeException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.REGULAR, CubeState.detect(cube));
        }
    }

    @Test
    public void testDetect_Cube_NullCube() throws InvalidCubeException {
        Cube cube = null;
        assertEquals(CubeState.INVALID, CubeState.detect(cube));
    }
}

