package com.view.runner;

import com.controller.printer.PrinterWrapper;
import com.model.CarSalonMVC;
import com.model.carparts.Car;

public interface RunnerApp extends CarSalonMVC.View {
    void run(CarSalonMVC.Controller carSalonMVC, PrinterWrapper printerWrapper, Car car);
}
