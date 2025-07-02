package ProductManager;

public class NotFoundExceptionTitle extends RuntimeException {
    public NotFoundExceptionTitle(String title) {
        super("Товар с id = " + title + " не найден");
    }
}
