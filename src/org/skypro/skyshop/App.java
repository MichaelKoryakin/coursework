package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product p1 = new Product("Молоко", 50);
        Product p2 = new Product("Хлеб", 30);
        Product p3 = new Product("Сыр", 120);
        Product p4 = new Product("Яблоко", 15);
        Product p5 = new Product("Масло", 90);
        Product p6 = new Product("Кофе", 200);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);
        basket.addProduct(p4);
        basket.addProduct(p5);
        basket.addProduct(p6); // корзина уже полная
        basket.printBasket();
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());
        System.out.println("Есть ли сыр? " + basket.hasProduct("Сыр"));
        System.out.println("Есть ли чай? " + basket.hasProduct("Чай"));
        basket.clear();
        basket.printBasket();
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());
        System.out.println("Есть ли молоко? " + basket.hasProduct("Молоко"));
    }
}