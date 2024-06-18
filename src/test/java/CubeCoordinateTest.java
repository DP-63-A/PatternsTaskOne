import static org.junit.Assert.*;
import org.junit.Test;
import edu.patterns.shapes.model.CubeCoordinate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CubeCoordinateTest {

    private String validCoordinatesFilePath = "src/test/resources/validCoordinates.txt";
    private String invalidCoordinatesFilePath = "src/test/resources/invalidCoordinates.txt";

    @Test
    public void testConstructorAndGetters() {
        CubeCoordinate coordinate = new CubeCoordinate(1.5, 2.5, 3.5);

        assertEquals(1.5, coordinate.getX(), 0.001);
        assertEquals(2.5, coordinate.getY(), 0.001);
        assertEquals(3.5, coordinate.getZ(), 0.001);
    }

    @Test
    public void testSetters() {
        CubeCoordinate coordinate = new CubeCoordinate();
        coordinate.setX(1.5);
        coordinate.setY(2.5);
        coordinate.setZ(3.5);

        assertEquals(1.5, coordinate.getX(), 0.001);
        assertEquals(2.5, coordinate.getY(), 0.001);
        assertEquals(3.5, coordinate.getZ(), 0.001);
    }

    @Test
    public void testDistanceTo_SameCoordinate() {
        CubeCoordinate coordinate1 = new CubeCoordinate(1, 2, 3);
        CubeCoordinate coordinate2 = new CubeCoordinate(1, 2, 3);

        double distance = coordinate1.distanceTo(coordinate2);

        assertEquals(0.0, distance, 0.001);
    }

    @Test
    public void testDistanceTo_DifferentCoordinates() {
        CubeCoordinate coordinate1 = new CubeCoordinate(1, 2, 3);
        CubeCoordinate coordinate2 = new CubeCoordinate(4, 5, 6);

        double distance = coordinate1.distanceTo(coordinate2);

        double expectedDistance = Math.sqrt(3*3 + 3*3 + 3*3);
        assertEquals(expectedDistance, distance, 0.001);
    }

    @Test
    public void testEquals_SameCoordinate() {
        CubeCoordinate coordinate1 = new CubeCoordinate(1, 2, 3);
        CubeCoordinate coordinate2 = new CubeCoordinate(1, 2, 3);

        assertTrue(coordinate1.equals(coordinate2));
    }

    @Test
    public void testEquals_DifferentCoordinates() {
        CubeCoordinate coordinate1 = new CubeCoordinate(1, 2, 3);
        CubeCoordinate coordinate2 = new CubeCoordinate(4, 5, 6);

        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void testToString() {
        CubeCoordinate coordinate = new CubeCoordinate(1.5, 2.5, 3.5);

        String expectedString = "{x=1.50, y=2.50, z=3.50}";
        assertEquals(expectedString, coordinate.toString());
    }

    @Test
    public void testFromFile_ValidCoordinates() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(validCoordinatesFilePath));

        for (String line : lines) {
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Double.parseDouble(parts[2]);

            CubeCoordinate coordinate = new CubeCoordinate(x, y, z);
            assertNotNull(coordinate);
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testFromFile_InvalidCoordinates() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(invalidCoordinatesFilePath));

        for (String line : lines) {
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Double.parseDouble(parts[2]);

            CubeCoordinate coordinate = new CubeCoordinate(x, y, z);
        }
    }
}
