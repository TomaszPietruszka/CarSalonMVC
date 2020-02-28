package com.controller.choice;


import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Brand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceBrandImplTest {
    Wallet wallet = new Wallet(20000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBrand tested = new ChoiceBrandImpl();

    @Test
    public void successfulChooseBMW() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Brand.BMW, car.getBrand());
    }

    @Test
    public void doNotTakeMoneyForBMW() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(20000, wallet.getMoney());
    }

    @Test
    public void printGetBMWMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose BMW brand");
    }

    @Test
    public void successfulChooseMercedes() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Brand.MERCEDES, car.getBrand());
    }

    @Test
    public void TakeMoneyForMercedes() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(15000, wallet.getMoney());
    }

    @Test
    public void printGetMercedesMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose MERCEDES brand");
    }

    @Test
    public void successfulChooseAudi() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Brand.AUDI, car.getBrand());
    }

    @Test
    public void TakeMoneyForAudi() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(10000, wallet.getMoney());
    }

    @Test
    public void printGetAudiMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose AUDI brand");
    }

    @Test
    public void trySetOneMinusOutOfBound() {
        Mockito.doReturn(-1, 1).when(scannerWrapper).nextInt();
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOneHundredMinusOutOfBound() {
        Mockito.doReturn(-100, 1).when(scannerWrapper).nextInt();
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOnePlusOutOfBound() {
        Mockito.doReturn(4, 1).when(scannerWrapper).nextInt();
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void  trySetOneHundredPlusOutOfBound() {
        Mockito.doReturn(100, 1).when(scannerWrapper).nextInt();
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }


}