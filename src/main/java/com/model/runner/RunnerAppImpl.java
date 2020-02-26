package com.model.runner;

import com.controller.printer.PrinterWrapper;
import com.model.CarSalonMVC;

public class RunnerAppImpl implements RunnerApp {


    @Override
    public void run(CarSalonMVC.Controller carSalonMVC, PrinterWrapper printerWrapper) {
        int choice = 0;
        while (true) {
            switch (choice) {
                case 0:
                    printerWrapper.print("Create your own car!");
                    carSalonMVC.createCar();
                    break;
                case 1:
                    choice = setCaseOne(carSalonMVC, printerWrapper, choice);
                    break;
                case 2:
                    printerWrapper.print("Choose brand: ");
                    carSalonMVC.chooseBrand();
                    if (carSalonMVC.getCar().getBrand() == null) {
                        choice -= 2;
                    }
                    break;
                case 3:
                    printerWrapper.print("Choose color: ");
                    carSalonMVC.chooseColor();
                    if (carSalonMVC.getCar().getColor() == null) {
                        choice -= 2;
                    }
                    break;
                case 4:
                    printerWrapper.print("Choose fuel: ");
                    carSalonMVC.chooseFuel();
                    if (carSalonMVC.getCar().getFuel() == null) {
                        choice -= 2;
                    }
                    break;
                case 5:
                    printerWrapper.print("Created car:");
                    carSalonMVC.getCar();
                    printerWrapper.print(carSalonMVC.getCar().toString());
                    return;
            }
            choice++;
        }
    }

    public int setCaseOne(CarSalonMVC.Controller carSalonMVC, PrinterWrapper printerWrapper, int i) {
        printerWrapper.print("Choose body: ");
        carSalonMVC.chooseBody();
        if (carSalonMVC.getCar().getBody() == null) {
            i -= 2;
        }
        return i;
    }

}
