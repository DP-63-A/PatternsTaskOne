import static org.junit.Assert.*;
import org.junit.Test;
import edu.patterns.shapes.model.CubeCoordinate;
import edu.patterns.shapes.service.CubeCoordinateService;

public class CubeCoordinateServiceTest {

    @Test
    public void testVectorMultiplication() {
        CubeCoordinate firstVector = new CubeCoordinate(1, 2, 3);
        CubeCoordinate secondVector = new CubeCoordinate(4, 5, 6);

        double expectedResult = 4 + 2*5 + 3*6;
        double result = CubeCoordinateService.vectorMultiplication(firstVector, secondVector);

        assertEquals(expectedResult, result, 0.001);
    }

    @Test
    public void testFindVector() {
        CubeCoordinate firstCoordinate = new CubeCoordinate(1, 2, 3);
        CubeCoordinate secondCoordinate = new CubeCoordinate(4, 5, 6);

        double expectedLength = Math.sqrt(3*3 + 3*3 + 3*3);
        double length = CubeCoordinateService.findVector(firstCoordinate, secondCoordinate);

        assertEquals(expectedLength, length, 0.001);
    }

    @Test
    public void testFindVectorModule() {
        CubeCoordinate vector = new CubeCoordinate(3, 4, 5);

        double expectedModule = Math.sqrt(3*3 + 4*4 + 5*5);
        double module = CubeCoordinateService.findVectorModule(vector);

        assertEquals(expectedModule, module, 0.001);
    }
}
