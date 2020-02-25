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
    Wallet wallet = new Wallet(1000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBody tested = new ChoiceBodyImpl();

    @Test
    public void chooseSedanBody() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("SEDAN");
        Assertions.assertEquals(Body.SEDAN, car.getBody());
    }

    @Test
    public void chooseHatchbackBody(){
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBody(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("HATCHBACK");
        Assertions.assertEquals(Body.HATCHBACK, car.getBody());
    }

    @Test
    public void failChooseSedanBody() {
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void failChooseHatchbackBody(){
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseBody(car, wallet, scannerWrapper, printerWrapper));
    }

}