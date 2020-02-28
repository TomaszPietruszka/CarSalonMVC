package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChoiceColorImplTest {
    Wallet wallet = new Wallet(2000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceColor tested = new ChoiceColorImpl();

/*    @Test
    public void chooseWhiteColor() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("WHITE");
        Assertions.assertEquals(Color.WHITE, car.getColor());
    }

    @Test
    public void chooseRedColor(){
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("RED");
        Assertions.assertEquals(Color.RED, car.getColor());
    }

    @Test
    public void failChooseWhiteColor() {
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseColor(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void failChooseRedColor(){
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseColor(car, wallet, scannerWrapper, printerWrapper));
    }*/

    @Test
    public void tryMinusValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(-100);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseColor(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void tryMinusOneValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(-1);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseColor(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryPlusValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(400);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseColor(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryPlusOneValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(4);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseColor(car, wallet, scannerWrapper, printerWrapper));
    }

}