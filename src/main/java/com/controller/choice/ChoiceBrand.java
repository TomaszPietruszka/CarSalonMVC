package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;

public interface ChoiceBrand {
    void chooseBrand(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper);
}
