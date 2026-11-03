import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.*;
import org.skypro.skyshop.basket.ProductBasket;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.add(new SimpleProduct("Молоко", 100));
        basket.add(new SimpleProduct("Хлеб", 50));
        basket.add(new SimpleProduct("Молоко", 120));
        basket.add(new SimpleProduct("Сыр", 250));

        // Удалить существующий продукт
        List<Product> deleted = basket.removeByName("Молоко");
        System.out.println("Удалённые продукты:");
        if (deleted.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : deleted) {
                System.out.println(p);
            }
        }
        basket.printBasket();

        // Удалить несуществующий продукт
        List<Product> deleted2 = basket.removeByName("Кефир");
        System.out.println("Удалённые продукты:");
        if (deleted2.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : deleted2) {
                System.out.println(p);
            }
        }
        basket.printBasket();
    }
}
