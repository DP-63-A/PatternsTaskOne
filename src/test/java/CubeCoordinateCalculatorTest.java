import static org.junit.Assert.*;
import org.junit.Test;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.service.CubeCoordinateCalculator;

public class CubeCoordinateCalculatorTest {

    @Test
    public void testDistanceOfCoordinates_SameCoordinates() {
        CubeCoordinate coordinate1 = new CubeCoordinate(1, 2, 3);
        CubeCoordinate coordinate2 = new CubeCoordinate(1, 2, 3);

        double distance = CubeCoordinateCalculator.distanceOfCoordinates(coordinate1, coordinate2);

        assertEquals(0.0, distance, 0.001);
    }

    @Test
    public void testDistanceOfCoordinates_DifferentCoordinates() {
        CubeCoordinate coordinate1 = new CubeCoordinate(1, 2, 3);
        CubeCoordinate coordinate2 = new CubeCoordinate(4, 5, 6);

        double distance = CubeCoordinateCalculator.distanceOfCoordinates(coordinate1, coordinate2);

        double expectedDistance = Math.sqrt(3*3 + 3*3 + 3*3);
        assertEquals(expectedDistance, distance, 0.001);
    }

    @Test
    public void testDistanceOfCoordinates_ZeroDifference() {
        CubeCoordinate coordinate1 = new CubeCoordinate(0, 0, 0);
        CubeCoordinate coordinate2 = new CubeCoordinate(0, 0, 0);

        double distance = CubeCoordinateCalculator.distanceOfCoordinates(coordinate1, coordinate2);

        assertEquals(0.0, distance, 0.001);
    }
}
