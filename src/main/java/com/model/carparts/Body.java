package com.model.carparts;

public enum Body {
    SEDAN(0),
    HATCHBACK(1000),
    PICKUP(2000);

    public int price;

    Body(int price) {
        this.price = price;
    }

}
