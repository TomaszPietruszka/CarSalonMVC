package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class FinishImplTest {
    Wallet wallet = new Wallet(20000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    Finish tested = new FinishImpl();

    @Test
    public void printMessage() {
        tested.finish(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Are you accept parameter of your car?");
    }

    @Test
    public void returnTrue() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        Assertions.assertTrue(tested.finish(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void returnFalse() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(0);
        Assertions.assertFalse(tested.finish(car, wallet, scannerWrapper, printerWrapper));
    }


}