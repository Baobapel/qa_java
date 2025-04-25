import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Parameterized.Parameters(name = "Для пола {0} наличие гривы должно быть {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveManeForDifferentSexes() throws Exception {
        Lion lion = new Lion(new Feline(), sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
