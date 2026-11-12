import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.*;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Яблоко", 80));
        engine.add(new SimpleProduct("Груша", 90));
        engine.add(new Article("Рецепт яблочного пирога", "Очень вкусно!"));
        engine.add(new Article("Груши в кулинарии", "Разные способы приготовления груш."));
        engine.add(new SimpleProduct("Груша", 100)); // не добавится, дубликат по имени

        System.out.println("\nРезультаты поиска по слову 'Груша':");
        for (Searchable s : engine.search("Груша")) {
            System.out.println(s.getStringRepresentation());
        }
    }
}
