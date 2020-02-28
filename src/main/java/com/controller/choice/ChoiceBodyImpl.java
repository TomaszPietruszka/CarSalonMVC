package com.controller.choice;

import com.controller.printer.PrinterWrapper;
import com.controller.scanner.ScannerWrapper;
import com.model.carParts.Car;
import com.model.wallet.Wallet;
import com.model.carParts.Body;

public class ChoiceBodyImpl extends ChoiceSetter implements ChoiceBody {

    @Override
    public void chooseBody(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        if (car.getBody() != null) {
            turnMoneyBack(wallet, printerWrapper, car.getBody().price);
            car.setBody(null);
        }

        printOptions(printerWrapper);
        switch (getOption(car, wallet, scannerWrapper, printerWrapper)) {
            case 1:
                setCase(car, wallet, scannerWrapper, printerWrapper, Body.SEDAN);
                break;
            case 2:
                setCase(car, wallet, scannerWrapper, printerWrapper, Body.HATCHBACK);
                break;
            case 3:
                setCase(car, wallet, scannerWrapper, printerWrapper, Body.PICKUP);
                break;
            case 0:
                return;
        }
    }


    private void setCase(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper, Body body) {
        if (wallet.getMoney() <= body.price) {
            printerWrapper.print("You haven't enough money");
            chooseBody(car, wallet, scannerWrapper, printerWrapper);
        } else {
            car.setBody(body);
            takeMoney(wallet, printerWrapper, car.getBody().price);
            printerWrapper.print("You choose " + car.getBody() + " body");
        }
    }

    @Override
    public void printOptions(PrinterWrapper printerWrapper) {
        int number = 0;
        for (Body value : Body.values()) {
            number++;
            printerWrapper.print(number + " " + value + " cost $" + value.price);
        }
    }

    @Override
    public int getOption(Car car, Wallet wallet, ScannerWrapper scannerWrapper, PrinterWrapper printerWrapper) {
        int option = scannerWrapper.nextInt();
        int lowBound = 0;
        int highBound = Body.values().length;

        if (option < lowBound || option > highBound) {
            printerWrapper.print("Wrong number!");
            chooseBody(car, wallet, scannerWrapper, printerWrapper);
            return 0;
        } else {
            return option;
        }
    }



}
