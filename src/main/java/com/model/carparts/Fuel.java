package com.model.carparts;

public enum Fuel {
    PETROL(0),
    DIESEL(1000),
    HYBRID(5000);

    public int price;

    Fuel(int price) {
        this.price = price;
    }
}
