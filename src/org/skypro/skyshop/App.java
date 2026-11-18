import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.*;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.add(new SimpleProduct("Молоко", 100));
        basket.add(new SimpleProduct("Хлеб", 50));
        basket.add(new SimpleProduct("Молоко", 120));
        basket.add(new SimpleProduct("Сыр", 250));
        basket.add(new FixPriceProduct("Сливки"));

        System.out.println("Удалённые продукты:");
        var deleted = basket.removeByName("Молоко");
        if (deleted.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            deleted.forEach(System.out::println);
        }
        basket.printBasket();
        basket.printSpecialCount();
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        // Пример поиска
        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Яблоко", 80));
        engine.add(new SimpleProduct("Груша", 90));
        engine.add(new Article("Рецепт яблочного пирога", "Очень вкусно!"));
        engine.add(new Article("Груши в кулинарии", "Разные способы приготовления груш."));

        System.out.println("\nРезультаты поиска по слову 'Груша':");
        for (Searchable s : engine.search("Груша")) {
            System.out.println(s.getStringRepresentation());
        }
    }
}
