package com.model.carparts;

public enum Color {
    WHITE(0),
    RED(1000),
    BLUE(2000);

    public int price;

    Color(int price) {
        this.price = price;
    }
}
