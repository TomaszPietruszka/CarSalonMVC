package com.controller.printer;

public class PrinterWrapperImpl implements PrinterWrapper {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

}
