package hw41.product;

public class Main {
    public static void main(String[] args) {
        // Создадим объект сервиса продукта
        ProductService service = new ProductService();

        // Добавим продукты внутрь сервиса для их хранения
        System.out.println("~~~~~~ ДОБАВЛЕНИЕ ПРОДУКТОВ В СЕРВИС ~~~~~~");
        try {
            service.addProduct(new Product("Банан", 120.0));
            service.addProduct(new Product("Яблоко", 70.0));
            service.addProduct(new Product("Персик", 230.0));
            service.addProduct(new Product("Арбуз", -180.0)); // Продукт с отрицательной ценой
            System.out.println("ПРОДУКТЫ УСПЕШНО ДОБАВЛЕНЫ В СЕРВИС");
        } catch (ProductInvalidException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println("\n~~~~~~ ПОИСК ПРОДУКТОВ ПО НАЗВАНИЮ ~~~~~~");
        try {
            Product product = service.findByTitle("Персик");
            System.out.println("ЦЕНА ПЕРСИКА: " + product.getPrice());

            product = service.findByTitle("Апельсин");
            System.out.println("ЦЕНА АПЕЛЬСИНА: " + product.getPrice());
        } catch (ProductNotFoundException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }
    }
}
