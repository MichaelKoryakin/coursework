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
    public Searchable searchBest(String search) throws BestResultNotFound {
        int max = 0;
        Searchable best = null;
        for (Searchable s : items) {
            if (s == null) continue;
            int count = countOccurrences(s.getSearchTerm(), search);
            if (count > max) {
                max = count;
                best = s;
            }
        }
        if (best == null || max == 0) {
            throw new BestResultNotFound(search);
        }
        return best;
    }
    private int countOccurrences(String str, String sub) {
        int count = 0, idx = 0;
        if (sub == null || sub.isEmpty()) return 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }
}
