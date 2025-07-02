package ProductManager;

public class NotFoundExceptionPrice extends RuntimeException {
    public NotFoundExceptionPrice(int price) {
        super("Товар с price = " + price + " не найден");
    }
}