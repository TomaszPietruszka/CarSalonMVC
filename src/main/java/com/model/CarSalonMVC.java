package com.model;

import com.model.carParts.Car;

public interface CarSalonMVC {

    interface Controller {

        void createCar();

        void chooseBody();

        void chooseBrand();

        void chooseColor();

        void chooseFuel();

        Car getCar();

    }

    interface View {

    }
}
