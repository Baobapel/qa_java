
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTests {

    private final Feline feline = new Feline();

    @Parameterized.Parameter
    public int inputKittensCount;

    @Parameterized.Parameter(1)
    public int expectedKittensCount;

    @Parameterized.Parameters(name = "getKittens({0}) should return {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},     // минимальное валидное значение
                {3, 3},     // обычное значение
                {0, 0},     // граничное значение
                {10, 10},   // большое значение
                {-1, -1}    // отрицательное значение (если поддерживается)
        });
    }

    @Test
    public void testGetKittensWithParamReturnsSameNumber() {
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }

}
