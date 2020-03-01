package com.model;

import com.controller.printer.PrinterWrapper;
import com.model.carparts.Car;

public interface CarSalonMVC {

    interface Controller {

        void setCar(Car car);

        void chooseBody();

        void chooseBrand();

        void chooseColor();

        void chooseFuel();

        boolean finish();

        Car getCar();

    }

    interface View {

        void run(CarSalonMVC.Controller carSalonMVC, PrinterWrapper printerWrapper, Car car);

    }
}
