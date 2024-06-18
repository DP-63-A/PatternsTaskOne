import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.patterns.shapes.creator.impl.CubeFactoryImpl;
import edu.patterns.shapes.exception.InvalidCubeException;
import edu.patterns.shapes.model.Cube;
import edu.patterns.shapes.model.CubeState;
import java.util.List;

public class CubeFactoryImplTest {

    private CubeFactoryImpl factory;
    private String validCubesFilePath = "src/test/resources/validCubes.txt";
    private String invalidCubesFilePath = "src/test/resources/invalidCubes.txt";

    @Before
    public void setUp() {
        factory = new CubeFactoryImpl();
    }

    @Test
    public void testCreateValidCubeFromFile() {
        List<Cube> cubes = factory.createCubesFromFile(validCubesFilePath);
        assertNotNull(cubes);
        assertFalse(cubes.isEmpty());
        for (Cube cube : cubes) {
            assertEquals(CubeState.REGULAR, cube.getState());
        }
    }

    @Test(expected = InvalidCubeException.class)
    public void testCreateCubeFromFileWithInvalidData() throws InvalidCubeException {
        factory.createCubesFromFile(invalidCubesFilePath);
    }
}
