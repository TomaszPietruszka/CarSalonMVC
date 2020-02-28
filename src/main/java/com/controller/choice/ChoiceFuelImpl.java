package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Fuel;

public class ChoiceFuelImpl implements ChoiceFuel {

    @Override
    public void chooseFuel(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        if (car.getFuel() != null) {
            wallet.turnMoneyBack(printerWrapper, car.getFuel().price);
            car.setFuel(null);
        }

        printOptions(printerWrapper);

        switch (getOption(car, wallet, scannerWrapper, printerWrapper)) {
            case 1:
                setCase(car, wallet, scannerWrapper, printerWrapper, Fuel.PETROL);
                break;
            case 2:
                setCase(car, wallet, scannerWrapper, printerWrapper, Fuel.DIESEL);
                break;
            case 3:
                setCase(car, wallet, scannerWrapper, printerWrapper, Fuel.HYBRID);
                break;
            case 0:
                return;
        }
    }

    private void setCase(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper, Fuel fuel) {
        if (wallet.getMoney() <= fuel.price) {
            printerWrapper.print("You haven't enough money");
            chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        } else {
            car.setFuel(fuel);
            wallet.takeMoney(printerWrapper, car.getFuel().price);
            printerWrapper.print("You choose " + car.getFuel() + " fuel");
        }
    }

    private int getOption(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        int option = scannerWrapper.nextInt();
        int lowBound = 0;
        int highBound = Fuel.values().length;

        if (option < lowBound || option > highBound) {
            printerWrapper.print("Wrong number!");
            chooseFuel(car, wallet, scannerWrapper, printerWrapper);
            return 0;
        } else {
            return option;
        }
    }

    private void printOptions(PrinterWrapper printerWrapper) {
        int number = 0;
        for (Fuel value : Fuel.values()) {
            number++;
            printerWrapper.print(number + " " + value + " cost $" + value.price);
        }
    }
}
