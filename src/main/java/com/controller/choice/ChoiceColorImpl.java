package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Color;

public class ChoiceColorImpl extends ChoiceSetter implements ChoiceColor {

    @Override
    public void chooseColor(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        if (car.getColor() != null) {
            turnMoneyBack(wallet, printerWrapper, car.getColor().price);
            car.setColor(null);
        }

        printOptions(printerWrapper);

        switch (getOption(car, wallet, scannerWrapper, printerWrapper)) {
            case 1:
                setCase(car, wallet, scannerWrapper, printerWrapper, Color.WHITE);
                break;
            case 2:
                setCase(car, wallet, scannerWrapper, printerWrapper, Color.RED);
                break;
            case 3:
                setCase(car, wallet, scannerWrapper, printerWrapper, Color.BLUE);
                break;
            case 0:
                return;
        }
    }

    public void setCase(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper, Color color) {
        if (wallet.getMoney() <= color.price) {
            printerWrapper.print("You haven't enough money");
            chooseColor(car, wallet, scannerWrapper, printerWrapper);
        } else {
            car.setColor(color);
            takeMoney(wallet, printerWrapper, car.getColor().price);
            printerWrapper.print("You choose " + car.getColor() + " color");
        }
    }

    @Override
    int getOption(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        int option = scannerWrapper.nextInt();
        int lowBound = 0;
        int highBound = Color.values().length;

        if (option < lowBound || option > highBound) {
            printerWrapper.print("Wrong number!");
            chooseColor(car, wallet, scannerWrapper, printerWrapper);
            return 0;
        } else {
            return option;
        }
    }

    @Override
    void printOptions(PrinterWrapper printerWrapper) {
        int number = 0;
        for (Color value : Color.values()) {
            number++;
            printerWrapper.print(number + " " + value + " cost $" + value.price);
        }
    }
}
