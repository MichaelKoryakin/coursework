package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Корзина заполнена");
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int specialCount = 0;
        boolean isEmpty = true;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
                isEmpty = false;
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }
}
