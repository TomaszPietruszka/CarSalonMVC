package com.controller;

import com.controller.choice.choicebody.ChoiceBody;
import com.controller.choice.choicebrand.ChoiceBrand;
import com.controller.choice.choicecolor.ChoiceColor;
import com.controller.choice.choicefuel.ChoiceFuel;
import com.controller.choice.finish.Finish;
import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carparts.Car;
import com.model.wallet.Wallet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarSalonControllerImplTest {
    Wallet wallet = new Wallet(10000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBody choiceBody = Mockito.mock(ChoiceBody.class);
    ChoiceBrand choiceBrand = Mockito.mock(ChoiceBrand.class);
    ChoiceColor choiceColor = Mockito.mock(ChoiceColor.class);
    ChoiceFuel choiceFuel = Mockito.mock(ChoiceFuel.class);
    Finish finish = Mockito.mock(Finish.class);

    CarSalonControllerImpl tested = new CarSalonControllerImpl(wallet, printerWrapper, scannerWrapper,
            choiceBody, choiceBrand, choiceColor, choiceFuel, finish);

    @Test
    public void chooseBody() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.setCar(car);
        tested.chooseBody();
        Mockito.verify(choiceBody).chooseBody(car, wallet, scannerWrapper, printerWrapper);
    }

    @Test
    public void chooseBrand() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.setCar(car);
        tested.chooseBrand();
        Mockito.verify(choiceBrand).chooseBrand(car, wallet, scannerWrapper, printerWrapper);
    }

    @Test
    public void chooseColor() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.setCar(car);
        tested.chooseColor();
        Mockito.verify(choiceColor).chooseColor(car, wallet, scannerWrapper, printerWrapper);
    }

    @Test
    public void chooseFuel() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.setCar(car);
        tested.chooseFuel();
        Mockito.verify(choiceFuel).chooseFuel(car, wallet, scannerWrapper, printerWrapper);
    }

    @Test
    public void finish() {
        tested.setCar(car);
        tested.finish();
        Mockito.verify(finish).finish(car, wallet, scannerWrapper, printerWrapper);
    }

}