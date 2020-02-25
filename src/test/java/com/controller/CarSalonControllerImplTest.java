package com.controller;

import com.controller.choice.*;
import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.wallet.Wallet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarSalonControllerImplTest {
    Wallet wallet = new Wallet(10000);
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBody choiceBody = Mockito.mock(ChoiceBody.class);
    ChoiceBrand choiceBrand = Mockito.mock(ChoiceBrand.class);
    ChoiceColor choiceColor = Mockito.mock(ChoiceColor.class);
    ChoiceFuel choiceFuel = Mockito.mock(ChoiceFuel.class);

    CarSalonControllerImpl tested = new CarSalonControllerImpl(wallet, printerWrapper, scannerWrapper,
            choiceBody, choiceBrand, choiceColor, choiceFuel);

    @Test
    public void chooseBody() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.createCar();
        tested.chooseBody();
        Mockito.verify(choiceBody).chooseBody(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void chooseBrand() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.createCar();
        tested.chooseBrand();
        Mockito.verify(choiceBrand).chooseBrand(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void ChooseColor() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.createCar();
        tested.chooseColor();
        Mockito.verify(choiceColor).chooseColor(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void ChooseFuel() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.createCar();
        tested.chooseFuel();
        Mockito.verify(choiceFuel).chooseFuel(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

}