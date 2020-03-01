package com.view.runner;

import com.controller.CarSalonControllerImpl;
import com.controller.choice.choicebody.ChoiceBody;
import com.controller.choice.choicebody.ChoiceBodyImpl;
import com.controller.choice.choicebrand.ChoiceBrand;
import com.controller.choice.choicebrand.ChoiceBrandImpl;
import com.controller.choice.choicecolor.ChoiceColor;
import com.controller.choice.choicecolor.ChoiceColorImpl;
import com.controller.choice.choicefuel.ChoiceFuel;
import com.controller.choice.choicefuel.ChoiceFuelImpl;
import com.controller.choice.finish.Finish;
import com.controller.choice.finish.FinishImpl;
import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carparts.*;
import com.model.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RunnerAppImplTest {
    Wallet wallet = new Wallet(20000);
    Car car = new Car();
    PrinterWrapper printerMock = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerMock = Mockito.mock(ScannerWrapper.class);
    ChoiceBody choiceBody = new ChoiceBodyImpl();
    ChoiceBrand choiceBrand = new ChoiceBrandImpl();
    ChoiceColor choiceColor = new ChoiceColorImpl();
    ChoiceFuel choiceFuel = new ChoiceFuelImpl();
    Finish finish = new FinishImpl();

    CarSalonControllerImpl carSalonMVC = new CarSalonControllerImpl(wallet, printerMock, scannerMock,
            choiceBody, choiceBrand, choiceColor, choiceFuel, finish);


    RunnerApp tested = new RunnerAppImpl();


    @Test
    public void successfulRunTest() {
        int sedanBody = 1;
        int bmwBrand = 1;
        int whiteColor = 1;
        int petrolFuel = 1;
        int finish = 1;

        Mockito.doReturn(sedanBody, bmwBrand, whiteColor, petrolFuel, finish).when(scannerMock).nextInt();
        tested.run(carSalonMVC, printerMock, car);
        Mockito.verify(printerMock).print("\nCongratulation! You created your new car!");
    }

    @Test
    public void runTestAndCheckIfPartsAreCorrect() {
        int hatchbackBody = 2;
        int mercedesBrand = 2;
        int blueColor = 3;
        int hybridFuel = 3;
        int finish = 1;
        Mockito.doReturn(hatchbackBody, mercedesBrand, blueColor, hybridFuel, finish ).when(scannerMock).nextInt();
        tested.run(carSalonMVC, printerMock, car);

        Assertions.assertEquals(carSalonMVC.getCar().getBody(), Body.HATCHBACK);
        Assertions.assertEquals(carSalonMVC.getCar().getBrand(), Brand.MERCEDES);
        Assertions.assertEquals(carSalonMVC.getCar().getColor(), Color.BLUE);
        Assertions.assertEquals(carSalonMVC.getCar().getFuel(), Fuel.HYBRID);
    }

    @Test
    public void stepBackRunTest() {
        int sedanBody = 1;
        int hatchbackBody = 2;
        int bmwBrand = 1;
        int mercedesBrand = 2;
        int whiteColor = 1;
        int redColor = 2;
        int petrolFuel = 1;
        int dieselFuel = 2;
        int hybridFuel = 3;
        int finish = 1;
        int back = 0;
        Mockito.doReturn(sedanBody, back, hatchbackBody, bmwBrand, back, mercedesBrand, whiteColor, back, redColor,
                petrolFuel, back, dieselFuel, back, hybridFuel, finish ).when(scannerMock).nextInt();
        tested.run(carSalonMVC, printerMock, car);
        Mockito.verify(printerMock).print("Car {body= HATCHBACK, brand= MERCEDES, color= RED, fuel= HYBRID}");

        Assertions.assertEquals(carSalonMVC.getCar().getBody(), Body.HATCHBACK);
        Assertions.assertEquals(carSalonMVC.getCar().getBrand(), Brand.MERCEDES);
        Assertions.assertEquals(carSalonMVC.getCar().getColor(), Color.RED);
        Assertions.assertEquals(carSalonMVC.getCar().getFuel(), Fuel.HYBRID);
    }

    @Test
    public void noNullRunTest() {
        Mockito.doReturn(1, 1, 1, 1).when(scannerMock).nextInt();
        tested.run((carSalonMVC), printerMock, car);
        Assertions.assertNotNull(carSalonMVC.getCar().getBody());
        Assertions.assertNotNull(carSalonMVC.getCar().getBrand());
        Assertions.assertNotNull(carSalonMVC.getCar().getColor());
        Assertions.assertNotNull(carSalonMVC.getCar().getFuel());
    }

}