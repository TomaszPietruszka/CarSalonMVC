package com.controller.scanner;

import java.util.Scanner;

public class ScannerWrapperImpl implements ScannerWrapper {
    @Override
    public int nextInt() {
        return new Scanner(System.in).nextInt();
    }
}
