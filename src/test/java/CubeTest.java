import static org.junit.Assert.*;
import org.junit.Test;
import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.model.CubeState;
import edu.patterns.shapes.creator.impl.CubeFactoryImpl;
import java.util.List;

public class CubeTest {

    private String validCubesFilePath = "src/test/resources/validCubes.txt";
    private String invalidCubesFilePath = "src/test/resources/invalidCubes.txt";

    @Test
    public void testCreateCube_ValidCoordinates() throws InvalidCubeException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.REGULAR, cube.getState());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateCube_InvalidNumberOfCoordinates() throws InvalidCubeException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(invalidCubesFilePath);

        for (Cube cube : cubes) {
            assertEquals(CubeState.INVALID, cube.getState());
        }
    }

    @Test
    public void testSetId_NewId() throws InvalidCubeException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);

        for (Cube cube : cubes) {
            int newId = 10;
            cube.setId(newId);
            assertEquals(newId, cube.getId());
        }
    }

    @Test
    public void testSetCoordinates_NewCoordinates() throws InvalidCubeException {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);

        for (Cube cube : cubes) {
            CubeCoordinate[] initialCoordinates = cube.getCoordinates();
            CubeCoordinate[] newCoordinates = {
                    new CubeCoordinate(0, 0, 0),
                    new CubeCoordinate(0, 2, 0),
                    new CubeCoordinate(1, 2, 0),
                    new CubeCoordinate(1, 0, 0),
                    new CubeCoordinate(0, 0, 2),
                    new CubeCoordinate(0, 2, 2),
                    new CubeCoordinate(1, 2, 2),
                    new CubeCoordinate(1, 0, 2)
            };
            cube.setCoordinates(newCoordinates);

            assertEquals(newCoordinates, cube.getCoordinates());
            assertEquals(CubeState.REGULAR, cube.getState());

            cube.setCoordinates(initialCoordinates);
        }
    }
}
