package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChoiceSetterTest {

    Wallet wallet = new Wallet(10000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ChoiceSetter choiceSetter = new ChoiceSetter() {
        @Override
        int getOption(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
            return 0;
        }

        @Override
        void printOptions(PrinterWrapper printerWrapper) {

        }
    };

    @Test
    void takeMoneyTest() {
        choiceSetter.takeMoney(wallet, printerWrapper, 1000);
        Assertions.assertEquals(9000, wallet.getMoney());
    }

    @Test
    void turnMoneyBackTest() {
        choiceSetter.turnMoneyBack(wallet, printerWrapper, 1000);
        Assertions.assertEquals(11000, wallet.getMoney());
    }

}