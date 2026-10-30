package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class SimpleProduct extends Product implements Searchable {
    public SimpleProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public String getStringRepresentation() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "product";
    }

    @Override
    public String getSearchTerm() {
        return getName(); // или другое подходящее поле
    }
}
