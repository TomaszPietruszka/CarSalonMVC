package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Fuel;

public class ChoiceFuelImpl implements ChoiceFuel {
    @Override
    public void chooseFuel(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        printerWrapper.print("Press 1 to choose petrol \nPress 2 to choose diesel \nPress 0 to back");
        int option = scannerWrapper.nextInt();
        switch (option) {
            case 1:
                if (wallet.getMoney() >= Fuel.PETROL.price) {
                    car.setFuel(Fuel.PETROL);
                    printerWrapper.print("PETROL");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 2:
                if (wallet.getMoney() >= Fuel.DIESEL.price) {
                    car.setFuel(Fuel.DIESEL);
                    printerWrapper.print("DIESEL");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 0:
                return;
        }
    }
}
