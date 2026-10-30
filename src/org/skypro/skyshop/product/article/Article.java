package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок статьи не должен быть пустым и не может состоять только из пробелов");
        }
        this.title = title;
        this.text = text;
    }

    public String getTitle() { return title; }
    public String getText() { return text; }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
    @Override
    public String getSearchTerm() {
        return toString();
    }
    @Override
    public String getContentType() {
        return "ARTICLE";
    }
    @Override
    public String getName() {
        return title;
    }
}
