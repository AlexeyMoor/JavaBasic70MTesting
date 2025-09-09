package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
Это тестовый класс.
Тестовый класс содержит тестовые методы.
 */

class ArrayServiceTest {
    private ArrayService service;

    @BeforeEach
    public void setUp() {
        service = new ArrayService();
    }
        /*
        Продумываем стратегию тестирования.
        Тест кейсы (что именно тестируем?):
        1. Передаем положительное значение. При этом проверяем тот ли размер имеет вернувшийся массив.
        2. Передаем положительное значение при этом проверяем корректные ли значения сохранены в ячейках массива.
        3. Передаем отрицательное значение. Проверяем, действительно ли метод при этом выбрасывает ожидаемый Exception.
        4. Передаем положительное значение. При этом проверяем, не вернулся ли null, вместо массива.
         */

    /*
    Как написать тестовый метод?
    1. Тестовые методы всегда public void
    2. Метод должен быть помечен аннотацией @Test.
    3. Метод должен иметь информативное название.
    4. Тестовый метод должен вызывать тестируемый метод и проверять,
       правильные или ли результаты выдает тестируемый метод.
     */

    // 4. Передаем положительное значение.
    // При этом проверяем, не вернулся ли null, вместо массива.
    @Test
    @DisplayName("Проверка, что метод не вернул null")
    public void checkIfArrayNotNull() {
        int[] result = service.generateArrayBySize(5);
        assertNotNull(result, "Метод вернул null, вместо ожидаемого массива");
    }

    // 1. Передаем положительное значение.
    // При этом проверяем тот ли размер имеет вернувшийся массив.
    @Test
    @DisplayName("Проверка, что метод вернул массив корректного размера")
    public void checkIfArraySizeIsCorrect() {
        int expectedSize = 5; // Ожидаемый размер
        int[] result = service.generateArrayBySize(expectedSize);
        int actualSize = result.length; // Актуальный размер
        assertEquals(expectedSize, actualSize, "Метод вернул не корректного размера");
    }

    // 3. Передаем отрицательное значение.
    // Проверяем, действительно ли метод при этом выбрасывает ожидаемый Exception.
    @Test
    @DisplayName("Проверка, что метод выбрасывает исключение при отрицательном размере массива")
    public void checkExceptionIfArraySizeIsNegative() {
        assertThrows(
                IncorrectArraySizeException.class,
                () -> service.generateArrayBySize(-1),
                "Метод не выбросил ожидаемое исключение при отрицательном размере массива"
        );
    }
}