package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.*;
import org.skypro.skyshop.article.Article;

public class App {
    public static void main(String[] args) {
        Product p1 = new SimpleProduct("Молоко", 50);
        Product p2 = new DiscountedProduct("Сыр", 120, 20);
        Product p3 = new FixPriceProduct("Масло");
        Product p4 = new SimpleProduct("Хлеб", 30);
        Product p5 = new DiscountedProduct("Кофе", 200, 10);
        Product p6 = new FixPriceProduct("Чай");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);
        basket.addProduct(p4);
        basket.addProduct(p5);
        basket.addProduct(p6); // шестой не добавится, если корзина на 5 товаров

        basket.printBasket();
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());
        System.out.println("Есть ли сыр? " + basket.hasProduct("Сыр"));
        System.out.println("Есть ли чай? " + basket.hasProduct("Чай"));
        basket.clear();
        basket.printBasket();
    }
}
