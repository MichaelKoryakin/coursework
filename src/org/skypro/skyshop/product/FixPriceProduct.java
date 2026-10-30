package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 150;

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    // Просто убираем @Override, если в Product нет такого метода
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
