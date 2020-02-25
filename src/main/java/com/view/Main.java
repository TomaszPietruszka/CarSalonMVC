package com.view;

import com.controller.CarSalonControllerImpl;
import com.controller.choice.*;
import com.controller.printer.PrinterWrapper;
import com.controller.printer.PrinterWrapperImpl;
import com.controller.scanner.ScannerWrapperImpl;
import com.model.CarSalonMVC;
import com.model.runner.RunnerApp;
import com.model.runner.RunnerAppImpl;
import com.model.wallet.Wallet;

public class Main implements CarSalonMVC.View {

    public static void main(String[] args) {

        CarSalonMVC.Controller carSalonMVC = new CarSalonControllerImpl(new Wallet(10000), new PrinterWrapperImpl(),
                new ScannerWrapperImpl(), new ChoiceBodyImpl(), new ChoiceBrandImpl(), new ChoiceColorImpl(), new ChoiceFuelImpl());

        PrinterWrapper printerWrapper = new PrinterWrapperImpl();

        RunnerApp runnerApp = new RunnerAppImpl();
        runnerApp.run(carSalonMVC, printerWrapper);

    }
}
