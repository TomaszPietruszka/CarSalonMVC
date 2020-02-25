package com.model.carParts;

public enum Brand {
    BMW(0),
    AUDI(1000);

    public int price;

    Brand(int price) {
        this.price = price;
    }
}
