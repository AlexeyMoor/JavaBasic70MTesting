package hw41.product;

/*
    Это класс - с пользовательским исключением,
    который будет выбрасываться при попытке сохранить продукт с некорректными данными
    (например, с пустым наименованием или отрицательной ценой).
 */
public class ProductInvalidException extends Exception {
    public ProductInvalidException(String message) {
        super(message);
    }
}