package com.view.runner;

import com.controller.printer.PrinterWrapper;
import com.model.CarSalonMVC;
import com.model.carparts.Car;

public class RunnerAppImpl implements RunnerApp {


    @Override
    public void run(CarSalonMVC.Controller carSalonMVC, PrinterWrapper printerWrapper, Car car) {
        int choice = 0;
        while (true) {
            switch (choice) {
                case 0:
                    printerWrapper.print("Create your own car!");
                    carSalonMVC.setCar(car);
                    break;
                case 1:
                    printerWrapper.print("\nSelect number of body or press 0 too back.");
                    carSalonMVC.chooseBody();
                    if (carSalonMVC.getCar().getBody() == null) {
                        choice -= 2;
                    }
                    break;
                case 2:
                    printerWrapper.print("\nSelect number of brand or press 0 too back.");
                    carSalonMVC.chooseBrand();
                    if (carSalonMVC.getCar().getBrand() == null) {
                        choice -= 2;
                    }
                    break;
                case 3:
                    printerWrapper.print("\nSelect number of color or press 0 too back.");
                    carSalonMVC.chooseColor();
                    if (carSalonMVC.getCar().getColor() == null) {
                        choice -= 2;
                    }
                    break;
                case 4:
                    printerWrapper.print("\nSelect number of fuel or press 0 too back.");
                    carSalonMVC.chooseFuel();
                    if (carSalonMVC.getCar().getFuel() == null) {
                        choice -= 2;
                    }
                    break;
                case 5:
                    printerWrapper.print("\nFinish process of creating car: ");
                    if (!carSalonMVC.finish()) {
                        choice -= 2;
                    }
                    break;
                case 6:
                    printerWrapper.print("\nCongratulation! You created your new car!");
                    carSalonMVC.getCar();
                    return;
            }
            choice++;
        }
    }


}
