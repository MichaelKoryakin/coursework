package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int count = 0;

    public SearchEngine(int size) {
        items = new Searchable[size];
    }

    public void add(Searchable s) {
        if (count < items.length) {
            items[count++] = s;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        for (Searchable s : items) {
            if (s != null && s.getSearchTerm().contains(query)) {
                results[found++] = s;
                if (found == 5) break;
            }
        }
        return results;
    }
}
