import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    private final Feline feline = new Feline();

    // Тест для метода eatMeat()
    @Test
    public void testEatMeatReturnsCorrectFoodList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    // Тест для метода getFood() (без параметров)
    @Test
    public void testGetFoodReturnsPredatorFood() {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.getFood();
        assertEquals(expectedFood, actualFood);
    }

    // Тест для метода getFamily()
    @Test
    public void testGetFamilyReturns12() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Тест для метода getKittens() без параметров
    @Test
    public void testGetKittensWithoutParamReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

}