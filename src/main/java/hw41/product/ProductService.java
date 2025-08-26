package hw41.product;

import java.util.ArrayList;
import java.util.List;

/*
Это класс, который является описанием сервиса для работы с продуктами.
Задача сервиса - управлять продуктами, например, добавлять, удалять, изменять и получать информацию о них.
/*
Задание 2:
    - Возьмите сервис продуктов из материалов занятия 36.
    - Напишите тесты на этот сервис (минимум 3 тест-кейса).
 */

public class ProductService {
    // Это поле - имитация базы данных, в котором будут храниться продукты.
    // В реальных приложениях это может быть база данных, файл или другой источник данных.
    private final List<Product> database = new ArrayList<>();

    // Метод для добавления продукта в сервис
    public void addProduct(Product product) throws ProductInvalidException {
        // Проверяем, что продукт не null, не имеет пустого значения и его цена не отрицательная
        if (product == null || product.getTitle() == null || product.getTitle().trim().isEmpty()) {
            // Если данные некорректны, выбрасываем пользовательское исключение с информативным сообщением
            throw new ProductInvalidException("Продукт не может быть добавлен, т.к. " +
                    "название не может быть пустым.");
        }
        if (product.getPrice() < 0) {
            // Если цена отрицательная, выбрасываем пользовательское исключение с соответствующим сообщением
            throw new ProductInvalidException("Продукт не может быть добавлен, т.к. цена не может быть отрицательной.");
        }
        database.add(product);
    }

    // Метод для получения продукта по названию и возвращает его
    public Product findByTitle(String title) throws ProductNotFoundException {
        for (Product product : database) {
            if (product.getTitle().equals(title)) {
                return product; // Возвращаем продукт, если его название совпадает с запрашиваемым
            }
        }
        // Если продукт с таким названием не найден,
        // выбрасываем пользовательское исключение с информативным сообщением
        throw new ProductNotFoundException(String.format("Продукт с названием %s не найден в базе данных", title));
    }
}
