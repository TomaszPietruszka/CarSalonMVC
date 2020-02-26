package com.model.runner;

import com.controller.CarSalonControllerImpl;
import com.controller.choice.*;
import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RunnerAppImplTest {
    Wallet wallet = new Wallet(10000);
    PrinterWrapper printerMock = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerMock = Mockito.mock(ScannerWrapper.class);
    ChoiceBody choiceBody = new ChoiceBodyImpl();
    ChoiceBrand choiceBrand = new ChoiceBrandImpl();
    ChoiceColor choiceColor = new ChoiceColorImpl();
    ChoiceFuel choiceFuel = new ChoiceFuelImpl();

    CarSalonControllerImpl carSalonMVC = new CarSalonControllerImpl(wallet, printerMock, scannerMock,
            choiceBody, choiceBrand, choiceColor, choiceFuel);

    RunnerApp tested = new RunnerAppImpl();


    @Test
    public void successfulRunTest() {
        int sedanBody = 1;
        int bmwBrand = 1;
        int whiteColor = 1;
        int petrolFuel = 1;

        Mockito.doReturn(sedanBody, bmwBrand, whiteColor, petrolFuel).when(scannerMock).nextInt();
        tested.run(carSalonMVC, printerMock);
        Mockito.verify(printerMock).print("Car{body=SEDAN, brand=BMW, color=WHITE, fuel=PETROL}");
    }

    @Test
    public void stepBackRunTest() {
        int sedanBody = 1;
        int hatchbackBody = 2;
        int bmwBrand = 1;
        int audiBrand = 2;
        int whiteColor = 1;
        int redColor = 2;
        int petrolFuel = 1;
        int dieselFuel = 2;
        int back = 0;
        Mockito.doReturn(sedanBody, back, hatchbackBody, bmwBrand, back, audiBrand, whiteColor, back, redColor, petrolFuel).when(scannerMock).nextInt();
        tested.run(carSalonMVC, printerMock);
        Mockito.verify(printerMock).print("Car{body=HATCHBACK, brand=AUDI, color=RED, fuel=PETROL}");
    }

    @Test
    public void noNullRunTest() {
        Mockito.doReturn(1, 1, 1, 1).when(scannerMock).nextInt();
        tested.run((carSalonMVC), printerMock);
        Assertions.assertNotNull(carSalonMVC.getCar().getBody());
        Assertions.assertNotNull(carSalonMVC.getCar().getBrand());
        Assertions.assertNotNull(carSalonMVC.getCar().getColor());
        Assertions.assertNotNull(carSalonMVC.getCar().getFuel());
    }

    @Test
    public void nullRunTest() {
        tested.run((carSalonMVC), printerMock);
        Assertions.assertNotNull(carSalonMVC.getCar().getBody());
        Assertions.assertNull(carSalonMVC.getCar().getBrand());
        Assertions.assertNull(carSalonMVC.getCar().getColor());
        Assertions.assertNull(carSalonMVC.getCar().getFuel());
    }


}