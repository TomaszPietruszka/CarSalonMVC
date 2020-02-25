package com.model.carParts;

public enum Color {
    WHITE(0),
    RED(1000);

    public int price;

    Color(int price) {
        this.price = price;
    }
}
