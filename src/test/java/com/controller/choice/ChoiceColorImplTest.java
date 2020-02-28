package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Color;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceColorImplTest {
    Wallet wallet = new Wallet(20000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceColor tested = new ChoiceColorImpl();

    @Test
    public void successfulChooseWhite() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Color.WHITE, car.getColor());
    }

    @Test
    public void doNotTakeMoneyForWhite() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(20000, wallet.getMoney());
    }

    @Test
    public void printGetWhiteMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose WHITE color");
    }
    @Test
    public void successfulChooseRed() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Color.RED, car.getColor());
    }

    @Test
    public void TakeMoneyForRed() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(19000, wallet.getMoney());
    }

    @Test
    public void printGetRedMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose RED color");
    }

    @Test
    public void successfulChooseBlue() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Color.BLUE, car.getColor());
    }

    @Test
    public void TakeMoneyForBlue() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(18000, wallet.getMoney());
    }

    @Test
    public void printGetBlueMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose BLUE color");
    }
    @Test
    public void trySetOneMinusOutOfBound() {
        Mockito.doReturn(-1, 1).when(scannerWrapper).nextInt();
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOneHundredMinusOutOfBound() {
        Mockito.doReturn(-100, 1).when(scannerWrapper).nextInt();
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOnePlusOutOfBound() {
        Mockito.doReturn(4, 1).when(scannerWrapper).nextInt();
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void  trySetOneHundredPlusOutOfBound() {
        Mockito.doReturn(100, 1).when(scannerWrapper).nextInt();
        tested.chooseColor(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

}