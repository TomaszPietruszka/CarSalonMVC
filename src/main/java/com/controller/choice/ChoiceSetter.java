package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;

public abstract class ChoiceSetter {

    abstract int getOption(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper);

    abstract void printOptions(PrinterWrapper printerWrapper);

    void takeMoney(Wallet wallet, PrinterWrapper printerWrapper, int amountOfMoney) {
        wallet.setMoney(wallet.getMoney() - amountOfMoney);
        printerWrapper.print("Now you have: $" + wallet.getMoney());
    }

    void turnMoneyBack(Wallet wallet, PrinterWrapper printerWrapper, int amountOfMoney) {
        wallet.setMoney(wallet.getMoney() + amountOfMoney);
        printerWrapper.print("Now you have: $" + wallet.getMoney());
    }
}
