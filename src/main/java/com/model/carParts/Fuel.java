package com.model.carParts;

public enum Fuel {
    PETROL(0),
    DIESEL(1000);

    public int price;

    Fuel(int price) {
        this.price = price;
    }
}
