package com.controller.choice.choicebrand;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carparts.Car;
import com.model.wallet.Wallet;
import com.model.carparts.Brand;

public class ChoiceBrandImpl implements ChoiceBrand {

    @Override
    public void chooseBrand(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        if (car.getBrand() != null) {
            wallet.turnMoneyBack(printerWrapper, car.getBrand().price);
            car.setBrand(null);
        }

        printOptions(printerWrapper);

        switch (getOption(car, wallet, scannerWrapper, printerWrapper)) {
            case 1:
                setCase(car, wallet, scannerWrapper, printerWrapper, Brand.BMW);
                break;
            case 2:
                setCase(car, wallet, scannerWrapper, printerWrapper, Brand.MERCEDES);
                break;
            case 3:
                setCase(car, wallet, scannerWrapper, printerWrapper, Brand.AUDI);
                break;
            case 0:
                return;
        }
    }

    private void setCase(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper, Brand brand) {
        if (wallet.getMoney() <= brand.price) {
            printerWrapper.print("You haven't enough money");
            chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        } else {
            car.setBrand(brand);
            wallet.takeMoney(printerWrapper, car.getBrand().price);
            printerWrapper.print("You choose " + car.getBrand() + " brand");
        }
    }

    private int getOption(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        int option = scannerWrapper.nextInt();
        int lowBound = 0;
        int highBound = Brand.values().length;

        if (option < lowBound || option > highBound) {
            printerWrapper.print("Wrong number!");
            chooseBrand(car, wallet, scannerWrapper, printerWrapper);
            return 0;
        } else {
            return option;
        }
    }

    private void printOptions(PrinterWrapper printerWrapper) {
        int number = 0;
        for (Brand value : Brand.values()) {
            number++;
            printerWrapper.print(number + " " + value + " cost $" + value.price);
        }
    }

}
