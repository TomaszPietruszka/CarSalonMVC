package com.controller;

import com.controller.choice.ChoiceBody;
import com.controller.choice.ChoiceBrand;
import com.controller.choice.ChoiceColor;
import com.controller.choice.ChoiceFuel;
import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.CarSalonMVC;
import com.model.wallet.Wallet;

public class CarSalonControllerImpl implements CarSalonMVC.Controller {

    private Car car;
    private PrinterWrapper printerWrapper;
    private ScannerWrapper scannerWrapper;
    private Wallet wallet;
    private ChoiceBrand choiceBrand;
    private ChoiceBody choiceBody;
    private ChoiceColor choiceColor;
    private ChoiceFuel choiceFuel;

    public CarSalonControllerImpl(Wallet wallet, PrinterWrapper printerWrapper, ScannerWrapper scannerWrapper, ChoiceBody choiceBody,
                                  ChoiceBrand choiceBrand, ChoiceColor choiceColor, ChoiceFuel choiceFuel) {
        this.wallet = wallet;
        this.printerWrapper = printerWrapper;
        this.scannerWrapper = scannerWrapper;
        this.choiceBody = choiceBody;
        this.choiceBrand = choiceBrand;
        this.choiceColor = choiceColor;
        this.choiceFuel = choiceFuel;
    }

    @Override
    public void createCar() {
        car = new Car();
    }

    @Override
    public void chooseBody() {
        choiceBody.chooseBody(car, wallet, scannerWrapper, printerWrapper);
    }

    @Override
    public void chooseBrand() {
        choiceBrand.chooseBrand(car, wallet, scannerWrapper, printerWrapper);
    }

    @Override
    public void chooseColor() {
        choiceColor.chooseColor(car, wallet, scannerWrapper, printerWrapper);
    }

    @Override
    public void chooseFuel() {
        choiceFuel.chooseFuel(car, wallet, scannerWrapper, printerWrapper);
    }

    @Override
    public Car getCar() {
        return car;
    }

}