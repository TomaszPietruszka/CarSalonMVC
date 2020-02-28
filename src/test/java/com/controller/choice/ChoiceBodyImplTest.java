package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Body;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ChoiceBodyImplTest {

    Wallet wallet = new Wallet(20000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBody tested = new ChoiceBodyImpl();


    @Test
    public void successfulChooseSedan() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Body.SEDAN, car.getBody());
    }

    @Test
    public void doNotTakeMoneyForSedan() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(20000, wallet.getMoney());
    }

    @Test
    public void printGetSedanMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose SEDAN body");
    }

    @Test
    public void successfulChooseHatchback() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Body.HATCHBACK, car.getBody());
    }

    @Test
    public void TakeMoneyForHatchback() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(19000, wallet.getMoney());
    }

    @Test
    public void printGetHatchbackMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose HATCHBACK body");
    }

    @Test
    public void successfulChoosePickup() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Body.PICKUP, car.getBody());
    }

    @Test
    public void TakeMoneyForPickup() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(18000, wallet.getMoney());
    }

    @Test
    public void printGetPickupMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose PICKUP body");
    }

    @Test
    public void trySetOneMinusOutOfBound() {
        Mockito.doReturn(-1, 1).when(scannerWrapper).nextInt();
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOneHundredMinusOutOfBound() {
        Mockito.doReturn(-100, 1).when(scannerWrapper).nextInt();
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOnePlusOutOfBound() {
        Mockito.doReturn(4, 1).when(scannerWrapper).nextInt();
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void  trySetOneHundredPlusOutOfBound() {
        Mockito.doReturn(100, 1).when(scannerWrapper).nextInt();
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }


}