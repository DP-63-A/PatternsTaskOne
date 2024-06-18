import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.service.CubeService;
import edu.patterns.shapes.creator.impl.CubeFactoryImpl;

import java.util.List;

public class CubeServiceTest {

    private CubeService cubeService;
    private String validCubesFilePath = "src/test/resources/validCubes.txt";

    @Before
    public void setUp() {
        cubeService = new CubeService();
    }

    @Test
    public void testCubeSurfaceArea() {
        CubeFactoryImpl factory = new CubeFactoryImpl();
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);
        for (Cube cube : cubes) {
            double expectedSurfaceArea = 6 * Math.pow(cube.getSideLength(), 2);
            double actualSurfaceArea = cubeService.cubeSurfaceArea(cube);
            assertEquals(expectedSurfaceArea, actualSurfaceArea, 0.01);
        }
    }
}

