package service;

public class ArrayService {
    /*
    Задача: Написать метод, который на вход принимает некоторое целое число N
    и возвращает массив размером N, заполненный числами от 1 до N.
    Пример:
    На вход: 5 -> [1, 2, 3, 4, 5]
    На вход: 3 -> [1, 2, 3]
    Если на вход подаётся отрицательное число, метод должен выбрасывать
    непроверяемое пользовательское исключение.
    */

    public int[] generateArrayBySize(int size) {
        if (size <= 0) {
            throw new IncorrectArraySizeException("Размер массива не может быть отрицательным!");
        }

        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
