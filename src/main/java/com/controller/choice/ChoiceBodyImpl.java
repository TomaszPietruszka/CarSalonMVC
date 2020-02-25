package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Body;

public class ChoiceBodyImpl implements ChoiceBody {

    @Override
    public void chooseBody(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        printerWrapper.print("Press 1 to choose SEDAN \nPress 2 to choose HATCHBACK \nPress 0 to back");
        int option = scannerWrapper.nextInt();
        switch (option) {
            case 1:
                if (wallet.getMoney() >= Body.SEDAN.price) {
                    car.setBody(Body.SEDAN);
                    printerWrapper.print("SEDAN");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 2:
                if (wallet.getMoney() >= Body.HATCHBACK.price) {
                    car.setBody(Body.HATCHBACK);
                    printerWrapper.print("HATCHBACK");
                } else {
                    throw new IllegalStateException("Not enough money");
                }
                break;
            case 0:
                return;
        }
    }
}
