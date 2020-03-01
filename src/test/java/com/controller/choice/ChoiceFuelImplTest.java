package com.controller.choice;

import com.controller.choice.choicefuel.ChoiceFuel;
import com.controller.choice.choicefuel.ChoiceFuelImpl;
import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carparts.Car;
import com.model.wallet.Wallet;
import com.model.carparts.Fuel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChoiceFuelImplTest {
    Wallet wallet = new Wallet(20000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceFuel tested = new ChoiceFuelImpl();

    @Test
    public void successfulChoosePetrol() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Fuel.PETROL, car.getFuel());
    }

    @Test
    public void doNotTakeMoneyForPetrol() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(20000, wallet.getMoney());
    }

    @Test
    public void printGetPetrolMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose PETROL fuel");
    }

    @Test
    public void successfulChooseDiesel() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Fuel.DIESEL, car.getFuel());
    }

    @Test
    public void doNotTakeMoneyForDiesel() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(19000, wallet.getMoney());
    }

    @Test
    public void printGetDieselMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose DIESEL fuel");
    }


    @Test
    public void successfulChooseHybrid() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(Fuel.HYBRID, car.getFuel());
    }

    @Test
    public void doNotTakeMoneyForHybrid() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        assertEquals(15000, wallet.getMoney());
    }

    @Test
    public void printGetHybridMessage() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(3);
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("You choose HYBRID fuel");
    }


    @Test
    public void trySetOneMinusOutOfBound() {
        Mockito.doReturn(-1, 1).when(scannerWrapper).nextInt();
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOneHundredMinusOutOfBound() {
        Mockito.doReturn(-100, 1).when(scannerWrapper).nextInt();
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void trySetOnePlusOutOfBound() {
        Mockito.doReturn(4, 1).when(scannerWrapper).nextInt();
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }

    @Test
    public void  trySetOneHundredPlusOutOfBound() {
        Mockito.doReturn(100, 1).when(scannerWrapper).nextInt();
        tested.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("Wrong number!");
    }


}