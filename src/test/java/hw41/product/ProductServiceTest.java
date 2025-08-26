package hw41.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    /*
     Тест кейсы:
     1. Добавление продукта соответствующего всем требованиям
     2. Проверка работоспособности Exception при добавлении в название продукта null
     3. Проверка работоспособности Exception при добавлении в название продукта "пустое значение"
     4. Проверка работоспособности Exception при добавлении отрицательной цены
     5. Проверка, что продукт действительно добавлен в "базу данных"
     */

    // 1. Добавление продукта соответствующего всем требованиям
    @Test
    public void checkAddProduct() {
        ProductService service = new ProductService();
        Product product = new Product("Помидор", 120);
        assertDoesNotThrow(() -> service.addProduct(product),
                "Добавление продукта соответствующего всем требованиям не должно выбрасывать Exception");

    }

    // 2. Проверка работоспособности Exception при добавлении в название продукта null
    @Test
    public void checkExceptionIfProductNameIsNull() {
        ProductService service = new ProductService();
        Product product = new Product(null, 120);
        assertThrows(ProductInvalidException.class,
                () -> service.addProduct(product),
                "Метод не выбросил ожидаемый Exception при добавлении null в название продукта"
        );
    }

    // 3. Проверка, работоспособности Exception при добавлении в название продукта "пустое значение"
    @Test
    public void checkExceptionIfProductNameIsEmpty() {
        ProductService service = new ProductService();
        Product product = new Product(" ", 120);
        assertThrows(ProductInvalidException.class,
                () -> service.addProduct(product),
                "Метод не выбросил ожидаемый Exception при добавлении в название продукта \"пустое значение\""
        );
    }

    // 4. Проверка работоспособности Exception при добавлении отрицательной цены
    @Test
    public void checkExceptionIfProductPriceIsNull() {
        ProductService service = new ProductService();
        Product product = new Product("", -120);
        assertThrows(ProductInvalidException.class,
                () -> service.addProduct(product),
                "Метод не выбросил ожидаемый Exception при добавлении отрицательной цены"
        );
    }

    // 5. Проверка, что продукт действительно добавлен в "базу данных"
    @Test
    public void checkAddedProduct() throws ProductInvalidException, ProductNotFoundException {
        ProductService service = new ProductService();
        Product product = new Product("Огурец", 60);
        service.addProduct(product);
        Product foundProduct = service.findByTitle("Огурец");
        assertEquals("Огурец", foundProduct.getTitle(),
                "Метод вернул не существующее наименование товара");
        assertEquals(60, foundProduct.getPrice(),
                "Метод вернул не существующую цену");
    }
}