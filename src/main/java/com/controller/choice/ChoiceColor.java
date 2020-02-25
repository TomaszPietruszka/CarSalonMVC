package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;

public interface ChoiceColor {
    void chooseColor(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper);
}
