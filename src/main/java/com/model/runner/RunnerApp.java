package com.model.runner;

import com.controller.printer.PrinterWrapper;
import com.model.CarSalonMVC;

public interface RunnerApp {
    void run(CarSalonMVC.Controller carSalonMVC, PrinterWrapper printerWrapper);


}
