package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Body;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChoiceBodyImplTest {

    Wallet wallet = new Wallet(10000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBody tested = new ChoiceBodyImpl();

    @Test
    public void chooseSedan() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose SEDAN body");
        Assertions.assertEquals(Body.SEDAN, car.getBody());
        Assertions.assertEquals(10000, wallet.getMoney());
    }

    @Test
    public void checkIfHatchbackIsNotEqualsSedan() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Assertions.assertNotEquals(Body.SEDAN, car.getBody());
    }

    @Test
    public void notEnoughMoneyToChooseSedan() {
        Wallet wallet = new Wallet(-1000);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void chooseHatchback() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose HATCHBACK body");
        Assertions.assertEquals(Body.HATCHBACK, car.getBody());
        Assertions.assertEquals(9000, wallet.getMoney());

    }

    @Test
    public void checkIfSedanIsNotEqualsHatchback() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Assertions.assertNotEquals(Body.HATCHBACK, car.getBody());
    }

    @Test
    public void notEnoughMoneyToChooseHatchback() {
        wallet = new Wallet(-1000);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void choosePickup() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose PICKUP body");
        Assertions.assertEquals(Body.PICKUP, car.getBody());
        Assertions.assertEquals(8000, wallet.getMoney());

    }

    @Test
    public void checkIfSedanIsNotEqualsPickup() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Assertions.assertNotEquals(Body.PICKUP, car.getBody());
    }

    @Test
    public void notEnoughMoneyToChoosePickup() {
        wallet = new Wallet(-1000);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryMinusValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(-100);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void tryMinusOneValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(-1);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryPlusValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(400);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }


    @Test
    public void tryPlusOneValueOverBound() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(4);
        Assertions.assertThrows(StackOverflowError.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }


}