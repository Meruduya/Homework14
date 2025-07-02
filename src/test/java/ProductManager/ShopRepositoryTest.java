package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductExist2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeByTitle("машина");

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundTitle() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundExceptionTitle.class,
                () -> repo.removeByTitle("сюрприз")
        );
    }

    @Test
    public void testNotFoundPrice() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundExceptionPrice.class,
                () -> repo.removeByPrice(5)
        );
    }

    @Test
    public void testFindByTitleReturnsNullWhenNotFound() {

        ShopRepository repo = new ShopRepository();

        // Убедитесь, что список products пуст или не содержит искомого заголовка
        String nonExistentTitle = "Некоторый несуществующий товар";

        Assertions.assertThrows(
                NotFoundExceptionTitle.class,
                () -> repo.removeByTitle(nonExistentTitle)
        );
    }

    @Test
    public void testRemoveWhenProductExist3() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeByPrice(300);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.removeById(12345)
        );
    }

    @Test
    public void testSetTitle() {
        Product product = new Product(1, "телефон", 30_000);
        String newTitle = "касса";
        product.setTitle(newTitle);

        assertEquals(newTitle, product.getTitle());

    }

    @Test
    public void testSetPrice() {
        Product product = new Product(1, "телефон", 30_000);
        int newPrice = 35_000;
        product.setPrice(newPrice);

        assertEquals(newPrice, product.getPrice());

    }

    @Test
    public void testEqualsSameObject() {
        Product p1 = new Product(1, "Товар", 1000);
        assertTrue(p1.equals(p1)); // объект равен сам себе
    }

    @Test
    public void testEqualsNull() {
        Product p1 = new Product(1, "Товар", 1000);
        assertFalse(p1.equals(null)); // сравнение с null — false
    }

    @Test
    public void testEqualsDifferentClass() {
        Product p1 = new Product(1, "Товар", 1000);
        String s = "не тот класс";
        assertFalse(p1.equals(s)); // сравнение с другим классом — false
    }

    @Test
    public void testEqualsEqualObjects() {
        Product p1 = new Product(1, "Товар", 1000);
        Product p2 = new Product(1, "Товар", 1000);
        assertTrue(p1.equals(p2)); // одинаковые поля — true
    }

    @Test
    public void testEqualsDifferentId() {
        Product p1 = new Product(1, "Товар", 1000);
        Product p2 = new Product(2, "Товар", 1000);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEqualsDifferentTitle() {
        Product p1 = new Product(1, "Товар", 1000);
        Product p2 = new Product(1, "Другой товар", 1000);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEqualsDifferentPrice() {
        Product p1 = new Product(1, "Товар", 1000);
        Product p2 = new Product(1, "Товар", 2000);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testHashCodeEqualObjects() {
        Product p1 = new Product(1, "Товар", 1000);
        Product p2 = new Product(1, "Товар", 1000);
        // Проверяем, что равные объекты имеют одинаковый hashCode
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() {
        Product p1 = new Product(1, "Товар", 1000);
        Product p2 = new Product(2, "Другой товар", 2000);
        // Хотя коллизии возможны, обычно ожидается разный хэш-код
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
}