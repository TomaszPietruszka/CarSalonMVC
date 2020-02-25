package com.model.carParts;

public enum Body {
    SEDAN(0),
    HATCHBACK(1000);

    public int price;

    Body(int price) {
        this.price = price;
    }

}
