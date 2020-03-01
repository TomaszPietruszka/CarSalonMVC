package com.model.carparts;

public class Car {
    private Body body;
    private Brand brand;
    private Color color;
    private Fuel fuel;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Car {" +
                "body= " + body +
                ", brand= " + brand +
                ", color= " + color +
                ", fuel= " + fuel +
                '}';
    }
}
