package com.controller.choice.finish;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carparts.Car;
import com.model.wallet.Wallet;

public class FinishImpl implements Finish {


    @Override
    public boolean finish(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        printerWrapper.print("Are you accept parameter of your car?");
        printerWrapper.print(car.toString());
        printerWrapper.print("You had left $:" + wallet.getMoney());
        printerWrapper.print("Press 1 to choose accept \nPress 0 to back");

        int option = scannerWrapper.nextInt();

        switch (option) {
            case 1:
                return true;
            case 0:
                return false;
            default:
                printerWrapper.print("wrong number");
                return false;
        }
    }
}
