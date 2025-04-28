import com.example.Feline;
import com.example.Predator;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    // Тесты исключений
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testInvalidSexThrowsException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        new Lion(new Feline(), "Неизвестный пол");
    }

    @Test
    public void testNullKittyInConstructorThrowsException() throws Exception {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Kitty не может быть null");
        new Lion(null, "Самец");
    }

    // Основные тесты

    @Mock
    private Predator PredatorMock;

    @Test
    public void testGetKittensDelegatesToKitty() throws Exception {
        when(PredatorMock.getKittens()).thenReturn(3);
        Lion lion = new Lion(PredatorMock, "Самец");
        assertEquals(3, lion.getKittens());
        verify(PredatorMock).getKittens();
    }

    @Test
    public void testGetFoodDelegatesToKitty() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(PredatorMock.getFood()).thenReturn(expectedFood);
        Lion lion = new Lion(PredatorMock, "Самка");
        assertEquals(expectedFood, lion.getFood());
        verify(PredatorMock).getFood();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullKittyThrowsException() throws Exception {
        new Lion(null, "Самец");
    }

    @Test
    public void testSingleParamConstructor() throws Exception {
        Lion lion = new Lion("Самец");
        assertNotNull(lion);
        assertTrue(lion.doesHaveMane());
    }

    // Проверка, что конструктор создаёт Lion при вызове с одним параметром
    @Test
    public void testSingleParamConstructorCreatesFeline() throws Exception {
        Lion lion = new Lion("Самка");
        assertEquals(1, lion.getKittens()); // Lion возвращает 1 по умолчанию
    }

    // Проверка getFood() бросает исключение, если kitty.getFood() бросает исключение
    @Test(expected = Exception.class)
    public void testGetFoodPropagatesException() throws Exception {
        when(PredatorMock.getFood()).thenThrow(new Exception("Ошибка в IKitty"));
        Lion lion = new Lion(PredatorMock, "Самец");
        lion.getFood();
    }

    @Test
    public void testEmptySexString() throws Exception {
        try {
            new Lion(new Feline(), "");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("самец или самка"));
        }
    }

    @Test
    public void testNullSexString() throws Exception {
        try {
            new Lion(new Feline(), null);
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("самец или самка"));
        }
    }

    @Test
    public void testSingleParamConstructorInitializesFeline() throws Exception {
        Lion lion = new Lion("Самец");
        assertNotNull(lion.getFood());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullKittyAndValidSex() throws Exception {
        new Lion(null, "Самец");
    }

    @Test
    public void testSingleParamConstructorUsesFeline() throws Exception {
        // Act
        Lion lion = new Lion("Самец");

        // Assert
        assertTrue(lion.doesHaveMane());
        assertEquals(1, lion.getKittens()); // Проверяем, что используется Feline (возвращает 1 по умолчанию)
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testSingleParamConstructorInitializesCorrectly() throws Exception {
        // Act
        Lion maleLion = new Lion("Самец");
        Lion femaleLion = new Lion("Самка");

        // Assert
        assertTrue(maleLion.doesHaveMane());
        assertFalse(femaleLion.doesHaveMane());
    }


}
