package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collection;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void add(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : new ArrayList<>();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Содержимое корзины:");
            for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
                for (Product p : entry.getValue()) {
                    System.out.println(p);
                }
            }
        }
    }
}
