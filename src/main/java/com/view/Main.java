package com.view;

import com.controller.CarSalonControllerImpl;
import com.controller.choice.choicebody.ChoiceBodyImpl;
import com.controller.choice.choicebrand.ChoiceBrandImpl;
import com.controller.choice.choicecolor.ChoiceColorImpl;
import com.controller.choice.choicefuel.ChoiceFuelImpl;
import com.controller.choice.finish.FinishImpl;
import com.controller.printer.PrinterWrapper;
import com.controller.printer.PrinterWrapperImpl;
import com.controller.scanner.ScannerWrapperImpl;
import com.model.CarSalonMVC;
import com.model.carparts.Car;
import com.view.runner.RunnerApp;
import com.view.runner.RunnerAppImpl;
import com.model.wallet.Wallet;

public class Main {

    public static void main(String[] args) {

        CarSalonMVC.Controller carSalonMVC = new CarSalonControllerImpl(new Wallet(15000), new PrinterWrapperImpl(),
                new ScannerWrapperImpl(), new ChoiceBodyImpl(), new ChoiceBrandImpl(), new ChoiceColorImpl(),
                new ChoiceFuelImpl(), new FinishImpl());

        PrinterWrapper printerWrapper = new PrinterWrapperImpl();
        Car car = new Car();
        RunnerApp runnerApp = new RunnerAppImpl();

        runnerApp.run(carSalonMVC, printerWrapper, car);

    }
}
