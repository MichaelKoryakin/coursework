package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;

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
        return items.stream()
                .filter(s -> s.getSearchTerm().contains(searchTerm))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}
