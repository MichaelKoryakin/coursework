package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable s) {
        items.add(s);
    }

    public Set<Searchable> search(String searchTerm) {
        Comparator<Searchable> comparator = (a, b) -> {
            int lenCmp = Integer.compare(b.getName().length(), a.getName().length());
            if (lenCmp != 0) {
                return lenCmp;
            }
            return a.getName().compareTo(b.getName());
        };
        Set<Searchable> results = new TreeSet<>(comparator);
        for (Searchable s : items) {
            if (s.getSearchTerm().contains(searchTerm)) {
                results.add(s);
            }
        }
        return results;
    }
}
