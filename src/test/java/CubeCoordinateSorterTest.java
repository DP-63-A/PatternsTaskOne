import static org.junit.Assert.*;
import org.junit.Test;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.service.CubeCoordinateSorter;

public class CubeCoordinateSorterTest {

    @Test
    public void testSortCoordinates() {
        CubeCoordinate[] unsortedCoordinates = new CubeCoordinate[] {
                new CubeCoordinate(2, 1, 3),
                new CubeCoordinate(0, 1, 2),
                new CubeCoordinate(1, 0, 1),
                new CubeCoordinate(3, 2, 0)
        };

        CubeCoordinate[] sortedCoordinates = CubeCoordinateSorter.sortCoordinates(unsortedCoordinates);

        CubeCoordinate[] expectedCoordinates = new CubeCoordinate[] {
                new CubeCoordinate(0, 1, 2),
                new CubeCoordinate(1, 0, 1),
                new CubeCoordinate(2, 1, 3),
                new CubeCoordinate(3, 2, 0)
        };

        assertArrayEquals(expectedCoordinates, sortedCoordinates);
    }
}
