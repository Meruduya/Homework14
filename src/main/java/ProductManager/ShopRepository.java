package ProductManager;

import java.util.Objects;

public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void removeById(int id) {
        Product removingProdact = findById(id);
        if (removingProdact == null) {
            throw new NotFoundException(id);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public void removeByTitle(String title) {
        Product removingProdact = findByTitle(title);
        if (removingProdact == null) {
            throw new NotFoundExceptionTitle(title);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (!Objects.equals(product.getTitle(), title)) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    private Product findByTitle(String title) {
        for (Product product : products) {
            if (Objects.equals(product.getTitle(), title)) {
                return product;
            }
        }
        return null;
    }


    // Этот способ мы рассматривали в теории в теме про композицию
    public void removeByPrice(int price) {
        Product removingProdact = findByPrice(price);
        if (removingProdact == null) {
            throw new NotFoundExceptionPrice(price);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getPrice() != price) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    private Product findByPrice(int price) {
        for (Product product : products) {
            if (product.getPrice() == price) {
                return product;
            }
        }
        return null;
    }
}