package service;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Проводим ручное тестирование метода нашего сервиса.

        /*
        Продумываем стратегию тестирования.
        Тест кейсы (что именно тестируем?):
        1. Передаем положительное значение. При этом проверяем тот ли размер имеет вернувшийся массив.
        2. Передаем положительное значение при этом проверяем корректные ли значения сохранены в ячейках массива.
        3. Передаем отрицательное значение. Проверяем, действительно ли метод при этом выбрасывает ожидаемый Exception.
        4. Передаем положительное значение. При этом проверяем, не вернулся ли null, вместо массива.
         */

        ArrayService service = new ArrayService();

        int[] result = service.generateArrayBySize(5);
        System.out.println(Arrays.toString(result));

        result = service.generateArrayBySize(14);
        System.out.println(Arrays.toString(result));

        result = service.generateArrayBySize(21);
        System.out.println(Arrays.toString(result));

        service.generateArrayBySize(-1);
        System.out.println(Arrays.toString(result));

    }
}
