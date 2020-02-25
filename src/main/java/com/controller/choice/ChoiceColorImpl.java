package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Color;

public class ChoiceColorImpl implements ChoiceColor {
    @Override
    public void chooseColor(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        printerWrapper.print("Press 1 to choose white car \nPress 2 to choose red car \nPress 0 to back");

        int option = scannerWrapper.nextInt();
        switch (option) {
            case 1:
                if (wallet.getMoney() >= Color.WHITE.price) {
                    car.setColor(Color.WHITE);
                    printerWrapper.print("WHITE");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 2:
                if (wallet.getMoney() >= Color.RED.price) {
                    car.setColor(Color.RED);
                    printerWrapper.print("RED");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 0:
                return;
        }
    }
}
