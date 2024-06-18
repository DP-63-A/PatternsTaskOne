import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.patterns.shapes.creator.impl.CubeCoordinateFactoryImpl;
import edu.patterns.shapes.exception.InvalidCoordinateException;
import edu.patterns.shapes.model.CubeCoordinate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CubeCoordinateFactoryImplTest {

    private CubeCoordinateFactoryImpl factory;
    private String validCoordinatesFilePath = "src/test/resources/validCoordinates.txt";
    private String invalidCoordinatesFilePath = "src/test/resources/invalidCoordinates.txt";

    @Before
    public void setUp() {
        factory = new CubeCoordinateFactoryImpl();
    }

    @Test
    public void testNewCubeCoordinate() {
        CubeCoordinate coordinate = factory.newCubeCoordinate(1.0, 2.0, 3.0);
        assertNotNull(coordinate);
        assertEquals(1.0, coordinate.getX(), 0.001);
        assertEquals(2.0, coordinate.getY(), 0.001);
        assertEquals(3.0, coordinate.getZ(), 0.001);
    }

    @Test
    public void testNewCubeCoordinates() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(validCoordinatesFilePath));
            double[][] coordinates = new double[lines.size()][3];
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                for (int j = 0; j < 3; j++) {
                    coordinates[i][j] = Double.parseDouble(parts[j]);
                }
            }
            CubeCoordinate[] coordinateArray = factory.newCubeCoordinates(coordinates);
            assertNotNull(coordinateArray);
            assertEquals(lines.size(), coordinateArray.length);
            for (int i = 0; i < lines.size(); i++) {
                assertEquals(coordinates[i][0], coordinateArray[i].getX(), 0.001);
                assertEquals(coordinates[i][1], coordinateArray[i].getY(), 0.001);
                assertEquals(coordinates[i][2], coordinateArray[i].getZ(), 0.001);
            }
        } catch (IOException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testNewCubeCoordinatesInvalidCoordinates() throws InvalidCoordinateException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(invalidCoordinatesFilePath));
            double[][] coordinates = new double[lines.size()][3];
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                for (int j = 0; j < 3; j++) {
                    coordinates[i][j] = Double.parseDouble(parts[j]);
                }
            }
            factory.newCubeCoordinates(coordinates);
        } catch (IOException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testNewCoordinates() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(validCoordinatesFilePath));
            double[][] coordinates = new double[lines.size()][3];
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                for (int j = 0; j < 3; j++) {
                    coordinates[i][j] = Double.parseDouble(parts[j]);
                }
            }
            CubeCoordinate[] coordinateArray = factory.newCoordinates(coordinates);
            assertNotNull(coordinateArray);
            assertEquals(lines.size(), coordinateArray.length);
            for (int i = 0; i < lines.size(); i++) {
                assertEquals(coordinates[i][0], coordinateArray[i].getX(), 0.001);
                assertEquals(coordinates[i][1], coordinateArray[i].getY(), 0.001);
                assertEquals(coordinates[i][2], coordinateArray[i].getZ(), 0.001);
            }
        } catch (IOException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testNewCoordinatesInvalidCoordinates() throws InvalidCoordinateException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(invalidCoordinatesFilePath));
            double[][] coordinates = new double[lines.size()][3];
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                for (int j = 0; j < 3; j++) {
                    coordinates[i][j] = Double.parseDouble(parts[j]);
                }
            }
            factory.newCoordinates(coordinates);
        } catch (IOException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
