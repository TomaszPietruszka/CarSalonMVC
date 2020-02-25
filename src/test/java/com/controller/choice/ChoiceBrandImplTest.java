package com.controller.choice;


import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Brand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChoiceBrandImplTest {
    Wallet wallet = new Wallet(2000);
    Car car = new Car();
    PrinterWrapper printerWrapper = Mockito.mock(PrinterWrapper.class);
    ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
    ChoiceBrand tested = new ChoiceBrandImpl();

    @Test
    public void chooseBmwBrand() {
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("BMW");
        Assertions.assertEquals(Brand.BMW, car.getBrand());
    }

    @Test
    public void chooseAudiBrand(){
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
        Mockito.verify(printerWrapper).print("AUDI");
        Assertions.assertEquals(Brand.AUDI, car.getBrand());
    }

    @Test
    public void failChooseBmwBrand() {
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(1);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper));
    }

    @Test
    public void failChooseAudiBrand(){
        wallet = new Wallet(-1);
        Mockito.when(scannerWrapper.nextInt()).thenReturn(2);
        Assertions.assertThrows(IllegalStateException.class, () -> tested.chooseBrand(car, wallet, scannerWrapper, printerWrapper));
    }

}