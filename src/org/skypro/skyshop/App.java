import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.*;

public class App {
    public static void main(String[] args) {
        // Демонстрация ошибок создания продуктов
        try {
            Product p = new SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        try {
            Product p = new SimpleProduct("Молоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        try {
            Product p = new DiscountedProduct("Сыр", 100, 200);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        // Добавление товаров и статей
        SearchEngine engine = new SearchEngine(10);
        engine.add(new SimpleProduct("Сыр", 300));
        engine.add(new SimpleProduct("Молоко", 100));
        engine.add(new Article("Как выбрать сыр", "Инструкция по выбору сыра сыр сыр сыр"));
        engine.add(new Article("Лучший кофе", "Пять советов по выбору кофе"));

        // Поиск best — успех
        try {
            Searchable best = engine.searchBest("сыр");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Поиск best — не найден
        try {
            Searchable best = engine.searchBest("несуществующее слово");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
