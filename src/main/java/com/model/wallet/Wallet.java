package com.model.wallet;

import com.controller.printer.PrinterWrapper;

public class Wallet {
    int money;

    public Wallet(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



    public void takeMoney(PrinterWrapper printerWrapper, int amountOfMoney) {
        setMoney(getMoney() - amountOfMoney);
        printerWrapper.print("Now you have: $" + getMoney());
    }
    public void turnMoneyBack(PrinterWrapper printerWrapper, int amountOfMoney) {
        setMoney(getMoney() + amountOfMoney);
        printerWrapper.print("Now you have: $" + getMoney());
    }

    void stareTAKEMONEY(Wallet wallet, PrinterWrapper printerWrapper, int amountOfMoney) {
        wallet.setMoney(wallet.getMoney() - amountOfMoney);
        printerWrapper.print("Now you have: $" + wallet.getMoney());
    }

    void STAREturnMoneyBack(Wallet wallet, PrinterWrapper printerWrapper, int amountOfMoney) {
        wallet.setMoney(wallet.getMoney() + amountOfMoney);
        printerWrapper.print("Now you have: $" + wallet.getMoney());
    }
}
