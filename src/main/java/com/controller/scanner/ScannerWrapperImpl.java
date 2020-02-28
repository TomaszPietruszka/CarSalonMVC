package com.controller.scanner;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class ScannerWrapperImpl implements ScannerWrapper {

    @Override
    public int nextInt() {

        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Invalid value! Please enter the number");
            nextInt();
        }
        return 0;
    }
}
