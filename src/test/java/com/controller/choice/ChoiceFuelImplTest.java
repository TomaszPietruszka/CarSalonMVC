package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Fuel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChoiceFuelImplTest {
    Wallet wallet = new Wallet(2000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceFuel tested = new ChoiceFuelImpl();

/*
    @Test
    public void choosePetrolFuel() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("PETROL");
        Assertions.assertEquals(Fuel.PETROL, car.getFuel());
    }

    @Test
    public void ChooseDieselFuel(){
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("DIESEL");
        Assertions.assertEquals(Fuel.DIESEL, car.getFuel());
    }

    @Test
    public void failChoosePetrolFuel() {
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void failChooseDieselFuel(){
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper));
    }
*/


    @Test
    public void tryMinusValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(-100);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void tryMinusOneValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(-1);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryPlusValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(400);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryPlusOneValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(4);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper));
    }


}