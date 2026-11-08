package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> items = new LinkedList<>();

    public void add(Searchable s) {
        items.add(s);
    }

    // Возвращает результаты поиска в виде отсортированной по имени мапы
    public Map<String, Searchable> search(String searchTerm) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable s : items) {
            if (s.getSearchTerm().contains(searchTerm)) {
                results.put(s.getName(), s);
            }
        }
        return results;
    }
}
