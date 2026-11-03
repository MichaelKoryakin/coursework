package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                removed.add(p);
                iterator.remove();
            }
        }
        return removed;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Содержимое корзины:");
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }
}
