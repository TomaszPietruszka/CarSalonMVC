package com.model.carParts;

public enum Brand {
    BMW(0),
    MERCEDES(5000),
    AUDI(10000);

    public int price;

    Brand(int price) {
        this.price = price;
    }
}
