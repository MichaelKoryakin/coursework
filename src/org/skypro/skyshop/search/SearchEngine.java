package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items = new LinkedList<>();

    public void add(Searchable s) {
        items.add(s);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable s : items) {
            if (s.getSearchTerm().contains(searchTerm)) {
                results.add(s);
            }
        }
        return results;
    }
}
