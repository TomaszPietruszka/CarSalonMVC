package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Brand;

public class ChoiceBrandImpl implements ChoiceBrand {

    @Override
    public void chooseBrand(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        printerWrapper.print("Press 1 to choose BMW \nPress 2 to choose AUDI \nPress 0 to back");
        car.setBrand(null);
        int option = scannerWrapper.nextInt();
        switch (option) {
            case 1:
                if (wallet.getMoney() >= Brand.BMW.price) {
                    car.setBrand(Brand.BMW);
                    printerWrapper.print("BMW");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 2:
                if (wallet.getMoney() >= Brand.AUDI.price) {
                    car.setBrand(Brand.AUDI);
                    printerWrapper.print("AUDI");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 0:
                return;
        }
    }

}
