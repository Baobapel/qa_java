import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    private Cat cat;

    @Mock
    private Feline felineMock;;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }
    @Test
    public void TestGetSoundReturnMeow () {
        String expected = "Мяу";
        Assert.assertEquals(expected, cat.getSound());
    }
    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood); // Feline реализует eatMeat()

        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
        verify(felineMock, times(1)).eatMeat();
    }
}
